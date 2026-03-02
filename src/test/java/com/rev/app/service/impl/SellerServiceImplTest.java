package com.rev.app.service.impl;

import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.ISellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SellerServiceImplTest {

    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private SellerServiceImpl sellerService;

    @Test
    void getSellerById_Success() {
        Seller seller = new Seller();
        seller.setSellerId(1);
        when(sellerRepository.findByUserUserId(1)).thenReturn(Optional.of(seller));

        Seller result = sellerService.getSellerById(1);

        assertNotNull(result);
        assertEquals(1, result.getSellerId());
    }

    @Test
    void getSellerById_NotFound() {
        when(sellerRepository.findByUserUserId(99)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> sellerService.getSellerById(99));
    }

    @Test
    void getSellerProducts_Success() {
        Seller seller = new Seller();
        seller.setSellerId(1);
        Product product = new Product();
        
        when(sellerRepository.findByUserUserId(1)).thenReturn(Optional.of(seller));
        when(productRepository.findBySellerSellerId(1)).thenReturn(List.of(product));

        List<Product> result = sellerService.getSellerProducts(1);

        assertFalse(result.isEmpty());
    }
}
