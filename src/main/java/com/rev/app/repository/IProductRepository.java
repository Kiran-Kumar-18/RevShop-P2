package com.rev.app.repository;

import com.rev.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySellerSellerId(Integer sellerId);
    List<Product> findByCategoryCategoryId(Integer categoryId);
    org.springframework.data.domain.Page<Product> findByCategoryCategoryId(Integer categoryId, org.springframework.data.domain.Pageable pageable);
    org.springframework.data.domain.Page<Product> findByNameContainingIgnoreCase(String name, org.springframework.data.domain.Pageable pageable);
    List<Product> findByNameContainingIgnoreCase(String name);

    // Active-only queries
    org.springframework.data.domain.Page<Product> findByIsActiveTrue(org.springframework.data.domain.Pageable pageable);
    org.springframework.data.domain.Page<Product> findByCategoryCategoryIdAndIsActiveTrue(Integer categoryId, org.springframework.data.domain.Pageable pageable);
    org.springframework.data.domain.Page<Product> findByNameContainingIgnoreCaseAndIsActiveTrue(String name, org.springframework.data.domain.Pageable pageable);
}


