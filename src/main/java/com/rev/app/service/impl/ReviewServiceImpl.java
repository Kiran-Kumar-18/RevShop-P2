package com.rev.app.service.impl;

import com.rev.app.dto.ReviewRequestDTO;
import com.rev.app.entity.Product;
import com.rev.app.entity.Review;
import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.IReviewRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.INotificationService;
import com.rev.app.service.IReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ReviewServiceImpl implements IReviewService {
    private static final Logger logger = LogManager.getLogger(ReviewServiceImpl.class);
    private final IReviewRepository ireviewRepository;
    private final IUserRepository iuserRepository;
    private final IProductRepository iproductRepository;
    private final INotificationService inotificationService;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO request) {
        User user = iuserRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));
        if ("ROLE_SELLER".equals(user.getRole())) {
            throw new RuntimeException("Sellers are not allowed to add reviews");
        }
        Product product = iproductRepository.findById(request.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + request.getProductId()));
        Review review = Review.builder().user(user).product(product).rating(request.getRating()).reviewText(request.getReviewText()).build();
        Review savedReview = ireviewRepository.save(review);
        
        // Notify Seller
        if (product.getSeller() != null && product.getSeller().getUser() != null) {
            String title = "New Review: " + product.getName();
            String message = user.getName() + " gave a " + request.getRating() + "-star review: \"" + 
                             (request.getReviewText().length() > 50 ? request.getReviewText().substring(0, 47) + "..." : request.getReviewText()) + "\"";
            inotificationService.createNotification(product.getSeller().getUser(), title, message, "REVIEW");
        }
        
        logger.info("Review added: ID: {}, User: {}, Product: {}, Rating: {}", savedReview.getReviewId(), request.getUserId(), request.getProductId(), request.getRating());
        return savedReview;
    }

    @Override
    public Page<Review> getProductReviews(Integer productId, Pageable pageable) {
        return ireviewRepository.findByProductProductId(productId, pageable);
    }

    @Override
    @Transactional
    public void deleteReview(Integer reviewId, Integer userId) {
        Review review = ireviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        
        if (!review.getUser().getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized: You can only delete your own reviews");
        }
        
        ireviewRepository.delete(review);
        logger.info("Review deleted: ID: {} by User ID: {}", reviewId, userId);
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewServiceImpl(final IReviewRepository ireviewRepository, final IUserRepository iuserRepository, final IProductRepository iproductRepository, final INotificationService inotificationService) {
        this.ireviewRepository = ireviewRepository;
        this.iuserRepository = iuserRepository;
        this.iproductRepository = iproductRepository;
        this.inotificationService = inotificationService;
    }
}
