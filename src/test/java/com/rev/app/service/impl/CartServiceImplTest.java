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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @Mock
    private ICartRepository cartRepository;
    @Mock
    private ICartItemRepository cartItemRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IUserRepository userRepository;
    
    @Mock
    private CartMapper cartMapper;

    @InjectMocks
    private CartServiceImpl cartService;

    private User user;
    private Product product;
    private Cart cart;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);
        user.setRole("ROLE_USER");

        product = Product.builder()
                .productId(1)
                .name("Cart Product")
                .stockQuantity(10)
                .build();

        cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
    }

    @Test
    void addItemToCart_NewItem_Success() {
        CartRequestDTO request = CartRequestDTO.builder().productId(1).quantity(2).build();

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(cartItemRepository.findByCartCartId(1)).thenReturn(new ArrayList<>());
        when(cartMapper.toDto(any(), any())).thenReturn(new CartResponseDTO());

        CartResponseDTO result = cartService.addItemToCart(1, request);

        assertNotNull(result);
        verify(cartItemRepository, times(1)).save(any(CartItem.class));
    }

    @Test
    void addItemToCart_ExistingItem_Success() {
        CartRequestDTO request = CartRequestDTO.builder().productId(1).quantity(3).build();
        CartItem existingItem = CartItem.builder().product(product).quantity(2).build();

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(cartItemRepository.findByCartCartId(1)).thenReturn(List.of(existingItem));
        when(cartMapper.toDto(any(), any())).thenReturn(new CartResponseDTO());

        cartService.addItemToCart(1, request);

        assertEquals(5, existingItem.getQuantity());
        verify(cartItemRepository, times(1)).save(existingItem);
    }

    @Test
    void addItemToCart_OutOfStock() {
        CartRequestDTO request = CartRequestDTO.builder().productId(1).quantity(2).build();
        product.setStockQuantity(0);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        assertThrows(RuntimeException.class, () -> cartService.addItemToCart(1, request));
    }

    @Test
    void addItemToCart_SellerDenied() {
        user.setRole("ROLE_SELLER");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> cartService.addItemToCart(1, new CartRequestDTO()));
    }

    @Test
    void removeItemFromCart_Success() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(cartMapper.toDto(any(), any())).thenReturn(new CartResponseDTO());

        cartService.removeItemFromCart(1, 10);

        verify(cartItemRepository, times(1)).deleteById(10);
    }
}
