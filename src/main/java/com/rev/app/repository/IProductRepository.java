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
    
    @org.springframework.data.jpa.repository.Query("SELECT p FROM Product p WHERE p.isActive = true " +
            "AND (:categoryId IS NULL OR p.category.categoryId = :categoryId) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:minRating IS NULL OR (SELECT COALESCE(AVG(r.rating), 0) FROM Review r WHERE r.product = p) >= :minRating)")
    org.springframework.data.domain.Page<Product> filterProducts(
            @org.springframework.data.repository.query.Param("categoryId") Integer categoryId,
            @org.springframework.data.repository.query.Param("minPrice") java.math.BigDecimal minPrice,
            @org.springframework.data.repository.query.Param("maxPrice") java.math.BigDecimal maxPrice,
            @org.springframework.data.repository.query.Param("keyword") String keyword,
            @org.springframework.data.repository.query.Param("minRating") Double minRating,
            org.springframework.data.domain.Pageable pageable);
}



