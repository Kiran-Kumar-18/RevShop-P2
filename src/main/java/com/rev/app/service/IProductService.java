package com.rev.app.service;

import com.rev.app.dto.ProductRequestDTO;
import com.rev.app.dto.ProductRequestDTO;
import com.rev.app.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);
    Page<ProductResponseDTO> getProductsByCategory(Integer categoryId, Pageable pageable);
    Page<ProductResponseDTO> searchProducts(String keyword, Pageable pageable);
    ProductResponseDTO getProductById(Integer id);
    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO updateProduct(Integer id, ProductRequestDTO request);
    void deleteProduct(Integer id);

    // Active-only methods
    Page<ProductResponseDTO> getAllActiveProducts(Pageable pageable);
    Page<ProductResponseDTO> getActiveProductsByCategory(Integer categoryId, Pageable pageable);
    Page<ProductResponseDTO> searchActiveProducts(String keyword, Pageable pageable);
    ProductResponseDTO getActiveProductById(Integer id);
    ProductResponseDTO updateStock(Integer id, Integer quantityChange);
    Page<ProductResponseDTO> filterActiveProducts(Integer categoryId, java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice, String keyword, Double minRating, Pageable pageable);
}



