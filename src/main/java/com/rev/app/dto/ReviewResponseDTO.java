package com.rev.app.dto;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    private Integer reviewId;
    private Integer userId;
    private String userName;
    private Integer productId;
    private Integer rating;
    private String reviewText;
    private LocalDateTime createdAt;


    @java.lang.SuppressWarnings("all")
    
    public static class ReviewResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer reviewId;
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private String userName;
        @java.lang.SuppressWarnings("all")
        
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        
        private Integer rating;
        @java.lang.SuppressWarnings("all")
        
        private String reviewText;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime createdAt;

        @java.lang.SuppressWarnings("all")
        
        ReviewResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder reviewId(final Integer reviewId) {
            this.reviewId = reviewId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder userName(final String userName) {
            this.userName = userName;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder rating(final Integer rating) {
            this.rating = rating;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder reviewText(final String reviewText) {
            this.reviewText = reviewText;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO.ReviewResponseDTOBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ReviewResponseDTO build() {
            return new ReviewResponseDTO(this.reviewId, this.userId, this.userName, this.productId, this.rating, this.reviewText, this.createdAt);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "ReviewResponseDTO.ReviewResponseDTOBuilder(reviewId=" + this.reviewId + ", userName=" + this.userName + ", productId=" + this.productId + ", rating=" + this.rating + ", reviewText=" + this.reviewText + ", createdAt=" + this.createdAt + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static ReviewResponseDTO.ReviewResponseDTOBuilder builder() {
        return new ReviewResponseDTO.ReviewResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getReviewId() {
        return this.reviewId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getUserName() {
        return this.userName;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getProductId() {
        return this.productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getRating() {
        return this.rating;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getReviewText() {
        return this.reviewText;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setReviewId(final Integer reviewId) {
        this.reviewId = reviewId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setRating(final Integer rating) {
        this.rating = rating;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setReviewText(final String reviewText) {
        this.reviewText = reviewText;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ReviewResponseDTO)) return false;
        final ReviewResponseDTO other = (ReviewResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$reviewId = this.getReviewId();
        final java.lang.Object other$reviewId = other.getReviewId();
        if (this$reviewId == null ? other$reviewId != null : !this$reviewId.equals(other$reviewId)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$rating = this.getRating();
        final java.lang.Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating)) return false;
        final java.lang.Object this$userName = this.getUserName();
        final java.lang.Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final java.lang.Object this$reviewText = this.getReviewText();
        final java.lang.Object other$reviewText = other.getReviewText();
        if (this$reviewText == null ? other$reviewText != null : !this$reviewText.equals(other$reviewText)) return false;
        final java.lang.Object this$createdAt = this.getCreatedAt();
        final java.lang.Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ReviewResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $reviewId = this.getReviewId();
        result = result * PRIME + ($reviewId == null ? 43 : $reviewId.hashCode());
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        final java.lang.Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final java.lang.Object $reviewText = this.getReviewText();
        result = result * PRIME + ($reviewText == null ? 43 : $reviewText.hashCode());
        final java.lang.Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "ReviewResponseDTO(reviewId=" + this.getReviewId() + ", userName=" + this.getUserName() + ", productId=" + this.getProductId() + ", rating=" + this.getRating() + ", reviewText=" + this.getReviewText() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewResponseDTO(final Integer reviewId, final Integer userId, final String userName, final Integer productId, final Integer rating, final String reviewText, final LocalDateTime createdAt) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.userName = userName;
        this.productId = productId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.createdAt = createdAt;
    }
}
