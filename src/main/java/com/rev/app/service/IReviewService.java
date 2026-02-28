package com.rev.app.service;

import com.rev.app.dto.ReviewRequestDTO;
import com.rev.app.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewService {
    Review addReview(ReviewRequestDTO request);
    Page<Review> getProductReviews(Integer productId, Pageable pageable);
    void deleteReview(Integer reviewId, Integer userId);
}


