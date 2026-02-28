package com.rev.app.service.impl;

import com.rev.app.entity.Favorite;
import com.rev.app.entity.Product;
import com.rev.app.entity.User;
import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IFavoriteRepository;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.IFavoriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    private final IFavoriteRepository ifavoriteRepository;
    private final IUserRepository iuserRepository;
    private final IProductRepository iproductRepository;

    @Override
    @Transactional
    public Favorite addFavorite(Integer userId, Integer productId) {
        User user = iuserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        if ("ROLE_SELLER".equals(user.getRole())) {
            throw new BadRequestException("Sellers are not allowed to add favorites");
        }
        Product product = iproductRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        // Check if already favorited
        List<Favorite> existing = ifavoriteRepository.findByUserUserId(userId);
        boolean alreadyFavorited = existing.stream().anyMatch(f -> f.getProduct().getProductId().equals(productId));
        if (alreadyFavorited) {
            throw new BadRequestException("Product already in favorites");
        }
        Favorite favorite = Favorite.builder().user(user).product(product).build();
        return ifavoriteRepository.save(favorite);
    }

    @Override
    @Transactional
    public void removeFavorite(Integer userId, Integer productId) {
        List<Favorite> favorites = ifavoriteRepository.findByUserUserId(userId);
        Favorite toDelete = favorites.stream().filter(f -> f.getProduct().getProductId().equals(productId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Favorite not found for product: " + productId));
        ifavoriteRepository.delete(toDelete);
    }

    @Override
    public List<Favorite> getUserFavorites(Integer userId) {
        return ifavoriteRepository.findByUserUserId(userId);
    }

    @java.lang.SuppressWarnings("all")
    
    public FavoriteServiceImpl(final IFavoriteRepository ifavoriteRepository, final IUserRepository iuserRepository, final IProductRepository iproductRepository) {
        this.ifavoriteRepository = ifavoriteRepository;
        this.iuserRepository = iuserRepository;
        this.iproductRepository = iproductRepository;
    }
}
