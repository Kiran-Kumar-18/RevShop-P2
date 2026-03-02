package com.rev.app.service.impl;

import com.rev.app.dto.ReviewRequestDTO;
import com.rev.app.entity.Product;
import com.rev.app.entity.Review;
import com.rev.app.entity.Seller;
import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.IReviewRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.INotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Mock
    private IReviewRepository reviewRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private INotificationService notificationService;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    private User user;
    private Product product;
    private ReviewRequestDTO reviewRequest;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);
        user.setName("John Doe");
        user.setRole("ROLE_BUYER");

        Seller seller = new Seller();
        User sellerUser = new User();
        sellerUser.setUserId(2);
        seller.setUser(sellerUser);

        product = new Product();
        product.setProductId(10);
        product.setSeller(seller);

        reviewRequest = new ReviewRequestDTO();
        reviewRequest.setUserId(1);
        reviewRequest.setProductId(10);
        reviewRequest.setRating(5);
        reviewRequest.setReviewText("Great product!");
    }

    @Test
    void addReview_BuyerSuccess() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(productRepository.findById(10)).thenReturn(Optional.of(product));
        when(reviewRepository.save(any(Review.class))).thenAnswer(i -> i.getArguments()[0]);

        Review result = reviewService.addReview(reviewRequest);

        assertNotNull(result);
        verify(reviewRepository, times(1)).save(any(Review.class));
        verify(notificationService, times(1)).createNotification(any(), any(), any(), any());
    }

    @Test
    void addReview_SellerDenied() {
        user.setRole("ROLE_SELLER");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> reviewService.addReview(reviewRequest));
    }

    @Test
    void getProductReviews_Success() {
        Page<Review> reviewPage = new PageImpl<>(List.of(new Review()));
        when(reviewRepository.findByProductProductId(eq(10), any())).thenReturn(reviewPage);

        Page<Review> result = reviewService.getProductReviews(10, PageRequest.of(0, 10));

        assertFalse(result.isEmpty());
    }

    @Test
    void deleteReview_OwnerSuccess() {
        Review review = Review.builder().user(user).build();
        when(reviewRepository.findById(100)).thenReturn(Optional.of(review));

        reviewService.deleteReview(100, 1);

        verify(reviewRepository, times(1)).delete(review);
    }

    @Test
    void deleteReview_Unauthorized() {
        Review review = Review.builder().user(user).build();
        when(reviewRepository.findById(100)).thenReturn(Optional.of(review));

        assertThrows(RuntimeException.class, () -> reviewService.deleteReview(100, 2));
    }
}
