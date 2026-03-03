package com.rev.app.service.impl;

import com.rev.app.dto.CartRequestDTO;
import com.rev.app.dto.CartResponseDTO;
import com.rev.app.entity.Cart;
import com.rev.app.entity.CartItem;
import com.rev.app.entity.Product;
import com.rev.app.entity.User;
import com.rev.app.mapper.CartMapper;
import com.rev.app.repository.ICartItemRepository;
import com.rev.app.repository.ICartRepository;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.ICartService;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
@org.springframework.transaction.annotation.Transactional
public class CartServiceImpl implements ICartService {
    private static final Logger logger = LogManager.getLogger(CartServiceImpl.class);
    private final ICartRepository icartRepository;
    private final ICartItemRepository icartItemRepository;
    private final IProductRepository iproductRepository;
    private final IUserRepository iuserRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponseDTO getCartByUserId(Integer userId) {
        if (userId == null) {
            throw new com.rev.app.exception.BadRequestException("User ID must not be null");
        }
        User user = iuserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if ("ROLE_SELLER".equals(user.getRole())) {
            throw new RuntimeException("Sellers do not have access to a cart");
        }
        Cart cart = getOrCreateCart(userId);
        List<CartItem> items = icartItemRepository.findByCartCartId(cart.getCartId());
        return cartMapper.toDto(cart, items);
    }

    @Override
    public CartResponseDTO addItemToCart(Integer userId, CartRequestDTO request) {
        if (userId == null) {
            throw new com.rev.app.exception.BadRequestException("User ID must not be null");
        }
        User user = iuserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if ("ROLE_SELLER".equals(user.getRole())) {
            throw new RuntimeException("Sellers are not allowed to add items to cart");
        }
        Cart cart = getOrCreateCart(userId);
        if (request.getProductId() == null) {
            throw new com.rev.app.exception.BadRequestException("Product ID must not be null");
        }
        Product product = iproductRepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getStockQuantity() == null || product.getStockQuantity() <= 0) {
            throw new RuntimeException("Product is out of stock");
        }
        if (product.getStockQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock. Only " + product.getStockQuantity() + " items left.");
        }
        List<CartItem> existingItems = icartItemRepository.findByCartCartId(cart.getCartId());
        Optional<CartItem> existingItemOpt = existingItems.stream().filter(item -> item.getProduct().getProductId().equals(product.getProductId())).findFirst();
        if (existingItemOpt.isPresent()) {
            CartItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
            if (product.getStockQuantity() < existingItem.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            icartItemRepository.save(existingItem);
            return getCartByUserId(userId);
        }
        CartItem newItem = CartItem.builder().cart(cart).product(product).quantity(request.getQuantity()).build();
        icartItemRepository.save(newItem);
        logger.info("Product ID: {} added to cart for user ID: {}", product.getProductId(), userId);
        return getCartByUserId(userId);
    }

    @Override
    public CartResponseDTO updateItemQuantity(Integer userId, Integer itemId, Integer quantity) {
        if (itemId == null) {
            throw new com.rev.app.exception.BadRequestException("Item ID must not be null");
        }
        
        CartItem item = icartItemRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Cart item not found"));
            
        if (quantity != null && quantity <= 0) {
            return removeItemFromCart(userId, itemId);
        }

        Product product = item.getProduct();
        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock. Only " + product.getStockQuantity() + " items left.");
        }

        item.setQuantity(quantity);
        icartItemRepository.save(item);
        logger.info("Updated quantity for Item ID: {} to {} for User ID: {}", itemId, quantity, userId);
        return getCartByUserId(userId);
    }

    @Override
    public CartResponseDTO removeItemFromCart(Integer userId, Integer itemId) {
        if (itemId == null) {
            throw new com.rev.app.exception.BadRequestException("Item ID must not be null");
        }
        icartItemRepository.deleteById(itemId);
        return getCartByUserId(userId);
    }

    @Override
    public CartResponseDTO clearCart(Integer userId) {
        logger.info("Clearing cart for user ID: {}", userId);
        Cart cart = getOrCreateCart(userId);
        List<CartItem> items = icartItemRepository.findByCartCartId(cart.getCartId());
        icartItemRepository.deleteAll(items);
        return cartMapper.toDto(cart, java.util.Collections.emptyList());
    }

    private Cart getOrCreateCart(Integer userId) {
        return icartRepository.findByUserUserId(userId).orElseGet(() -> {
            User user = iuserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            return icartRepository.save(Cart.builder().user(user).build());
        });
    }

    @java.lang.SuppressWarnings("all")

    public CartServiceImpl(final ICartRepository icartRepository, final ICartItemRepository icartItemRepository, final IProductRepository iproductRepository, final IUserRepository iuserRepository, final CartMapper cartMapper) {
        this.icartRepository = icartRepository;
        this.icartItemRepository = icartItemRepository;
        this.iproductRepository = iproductRepository;
        this.iuserRepository = iuserRepository;
        this.cartMapper = cartMapper;
    }
}
