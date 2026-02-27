package com.rev.app.controller;

import com.rev.app.dto.ReviewRequestDTO;
import com.rev.app.dto.ReviewResponseDTO;
import com.rev.app.mapper.ReviewMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final IReviewService ireviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> addReview(@Valid @RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO review = reviewMapper.toDto(ireviewService.addReview(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(review, "Review added successfully"));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<Page<ReviewResponseDTO>>> getProductReviews(@PathVariable Integer productId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ReviewResponseDTO> reviews = ireviewService.getProductReviews(productId, pageable).map(reviewMapper::toDto);
        return ResponseEntity.ok(ApiResponse.success(reviews, "Product reviews fetched successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteReview(@PathVariable Integer id, @RequestParam Integer userId) {
        ireviewService.deleteReview(id, userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Review deleted successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewController(final IReviewService ireviewService, final ReviewMapper reviewMapper) {
        this.ireviewService = ireviewService;
        this.reviewMapper = reviewMapper;
    }
}
