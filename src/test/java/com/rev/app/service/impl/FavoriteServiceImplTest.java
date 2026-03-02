package com.rev.app.service.impl;

import com.rev.app.entity.Favorite;
import com.rev.app.entity.Product;
import com.rev.app.entity.User;
import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IFavoriteRepository;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FavoriteServiceImplTest {

    @Mock
    private IFavoriteRepository favoriteRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private FavoriteServiceImpl favoriteService;

    private User user;
    private Product product;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);
        user.setRole("ROLE_BUYER");

        product = new Product();
        product.setProductId(10);
    }

    @Test
    void addFavorite_Success() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(10)).thenReturn(Optional.of(product));
        when(favoriteRepository.findByUserUserId(1)).thenReturn(new ArrayList<>());
        when(favoriteRepository.save(any(Favorite.class))).thenAnswer(i -> i.getArguments()[0]);

        Favorite result = favoriteService.addFavorite(1, 10);

        assertNotNull(result);
        assertEquals(user, result.getUser());
        assertEquals(product, result.getProduct());
        verify(favoriteRepository, times(1)).save(any(Favorite.class));
    }

    @Test
    void addFavorite_SellerDenied() {
        user.setRole("ROLE_SELLER");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> favoriteService.addFavorite(1, 10));
    }

    @Test
    void addFavorite_AlreadyFavorited() {
        Favorite existingFavorite = Favorite.builder().product(product).build();
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(10)).thenReturn(Optional.of(product));
        when(favoriteRepository.findByUserUserId(1)).thenReturn(List.of(existingFavorite));

        assertThrows(BadRequestException.class, () -> favoriteService.addFavorite(1, 10));
    }

    @Test
    void removeFavorite_Success() {
        Favorite favorite = Favorite.builder().product(product).build();
        when(favoriteRepository.findByUserUserId(1)).thenReturn(List.of(favorite));

        favoriteService.removeFavorite(1, 10);

        verify(favoriteRepository, times(1)).delete(favorite);
    }

    @Test
    void removeFavorite_NotFound() {
        when(favoriteRepository.findByUserUserId(1)).thenReturn(new ArrayList<>());

        assertThrows(ResourceNotFoundException.class, () -> favoriteService.removeFavorite(1, 10));
    }

    @Test
    void getUserFavorites_Success() {
        when(favoriteRepository.findByUserUserId(1)).thenReturn(List.of(new Favorite()));
        List<Favorite> result = favoriteService.getUserFavorites(1);
        assertFalse(result.isEmpty());
    }
}
