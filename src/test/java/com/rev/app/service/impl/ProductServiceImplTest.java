package com.rev.app.service.impl;

import com.rev.app.dto.ProductRequestDTO;
import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.entity.Category;
import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;
import com.rev.app.entity.User;
import com.rev.app.mapper.ProductMapper;
import com.rev.app.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;
    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private IReviewRepository reviewRepository;
    @Mock
    private IOrderItemRepository orderItemRepository;
    
    @Spy
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private Category category;
    private Seller seller;
    private User user;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setCategoryId(1);
        category.setName("Electronics");

        user = new User();
        user.setUserId(1);
        user.setEmail("seller@example.com");

        seller = new Seller();
        seller.setSellerId(1);
        seller.setUser(user);
        seller.setBusinessName("Test Store");

        product = Product.builder()
                .productId(1)
                .name("Smartphone")
                .price(new BigDecimal("500.00"))
                .stockQuantity(10)
                .category(category)
                .seller(seller)
                .isActive(true)
                .build();
    }

    @Test
    void getProductById_Success() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(reviewRepository.getAverageRatingByProductId(1)).thenReturn(4.5);
        when(orderItemRepository.countSoldCountByProductId(1)).thenReturn(20);

        ProductResponseDTO result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals("Smartphone", result.getName());
        assertEquals(4.5, result.getAverageRating());
        assertEquals(20, result.getSoldCount());
    }

    @Test
    void getProductById_NotFound() {
        when(productRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.getProductById(99));
    }

    @Test
    void createProduct_Success() {
        ProductRequestDTO request = ProductRequestDTO.builder()
                .name("Laptop")
                .categoryId(1)
                .sellerId(1)
                .price(new BigDecimal("1000.00"))
                .stockQuantity(5)
                .build();

        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        when(sellerRepository.findByUserUserId(1)).thenReturn(Optional.of(seller));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponseDTO result = productService.createProduct(request);

        assertNotNull(result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void createProduct_CategoryNotFound() {
        ProductRequestDTO request = ProductRequestDTO.builder()
                .categoryId(99)
                .sellerId(1)
                .build();

        when(categoryRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.createProduct(request));
    }

    @Test
    void updateStock_Increase() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponseDTO result = productService.updateStock(1, 5);

        assertEquals(15, product.getStockQuantity());
    }

    @Test
    void updateStock_DecreaseBelowZero() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        productService.updateStock(1, -20);

        assertEquals(0, product.getStockQuantity());
    }
}
