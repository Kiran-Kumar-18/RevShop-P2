package com.rev.app.repository;

import com.rev.app.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductProductId(Integer productId);
    Page<Review> findByProductProductId(Integer productId, Pageable pageable);
    List<Review> findByUserUserId(Integer userId);

    @org.springframework.data.jpa.repository.Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.productId = :productId")
    Double getAverageRatingByProductId(Integer productId);
}


