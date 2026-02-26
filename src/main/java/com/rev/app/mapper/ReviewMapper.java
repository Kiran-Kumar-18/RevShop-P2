package com.rev.app.mapper;

import com.rev.app.dto.ReviewResponseDTO;
import com.rev.app.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewResponseDTO toDto(Review entity) {
        if (entity == null) {
            return null;
        }

        return ReviewResponseDTO.builder()
                .reviewId(entity.getReviewId())
                .userId(entity.getUser() != null ? entity.getUser().getUserId() : null)
                .userName(entity.getUser() != null ? entity.getUser().getName() : null)
                .productId(entity.getProduct() != null ? entity.getProduct().getProductId() : null)
                .rating(entity.getRating())
                .reviewText(entity.getReviewText())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

