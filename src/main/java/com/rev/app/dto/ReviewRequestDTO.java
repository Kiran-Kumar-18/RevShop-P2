package com.rev.app.dto;

public class ReviewRequestDTO {
    private Integer userId;
    private Integer productId;
    private Integer rating;
    private String reviewText;


    @java.lang.SuppressWarnings("all")
    
    public static class ReviewRequestDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        
        private Integer rating;
        @java.lang.SuppressWarnings("all")
        
        private String reviewText;

        @java.lang.SuppressWarnings("all")
        
        ReviewRequestDTOBuilder() {
        }

        @java.lang.SuppressWarnings("all")
        
        public ReviewRequestDTO.ReviewRequestDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewRequestDTO.ReviewRequestDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewRequestDTO.ReviewRequestDTOBuilder rating(final Integer rating) {
            this.rating = rating;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ReviewRequestDTO.ReviewRequestDTOBuilder reviewText(final String reviewText) {
            this.reviewText = reviewText;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ReviewRequestDTO build() {
            return new ReviewRequestDTO(this.userId, this.productId, this.rating, this.reviewText);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "ReviewRequestDTO.ReviewRequestDTOBuilder(userId=" + this.userId + ", productId=" + this.productId + ", rating=" + this.rating + ", reviewText=" + this.reviewText + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static ReviewRequestDTO.ReviewRequestDTOBuilder builder() {
        return new ReviewRequestDTO.ReviewRequestDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getUserId() {
        return this.userId;
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
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
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

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ReviewRequestDTO)) return false;
        final ReviewRequestDTO other = (ReviewRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$rating = this.getRating();
        final java.lang.Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating)) return false;
        final java.lang.Object this$reviewText = this.getReviewText();
        final java.lang.Object other$reviewText = other.getReviewText();
        if (this$reviewText == null ? other$reviewText != null : !this$reviewText.equals(other$reviewText)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ReviewRequestDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        final java.lang.Object $reviewText = this.getReviewText();
        result = result * PRIME + ($reviewText == null ? 43 : $reviewText.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "ReviewRequestDTO(userId=" + this.getUserId() + ", productId=" + this.getProductId() + ", rating=" + this.getRating() + ", reviewText=" + this.getReviewText() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public ReviewRequestDTO(final Integer userId, final Integer productId, final Integer rating, final String reviewText) {
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
        this.reviewText = reviewText;
    }
}
