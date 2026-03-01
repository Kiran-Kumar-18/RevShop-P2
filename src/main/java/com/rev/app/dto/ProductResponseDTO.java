package com.rev.app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductResponseDTO {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal mrp;
    private BigDecimal discountPrice;
    private Integer stockQuantity;
    private Boolean isActive;
    private Integer sellerId;
    private String categoryName;
    private String sellerBusinessName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String imageUrl;
    private Double averageRating;
    private Integer soldCount;


    @java.lang.SuppressWarnings("all")
    
    public static class ProductResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        
        private String name;
        @java.lang.SuppressWarnings("all")
        
        private String description;
        @java.lang.SuppressWarnings("all")
        
        private BigDecimal price;
        @java.lang.SuppressWarnings("all")
        
        private BigDecimal mrp;
        @java.lang.SuppressWarnings("all")
        
        private BigDecimal discountPrice;
        @java.lang.SuppressWarnings("all")
        
        private Integer stockQuantity;
        @java.lang.SuppressWarnings("all")
        
        private Boolean isActive;
        private Integer sellerId;
        @java.lang.SuppressWarnings("all")
        
        private String categoryName;
        @java.lang.SuppressWarnings("all")
        
        private String sellerBusinessName;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime createdAt;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime updatedAt;
        @java.lang.SuppressWarnings("all")
        
        private String imageUrl;
        private Double averageRating;
        private Integer soldCount;

        @java.lang.SuppressWarnings("all")
        
        ProductResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder price(final BigDecimal price) {
            this.price = price;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder mrp(final BigDecimal mrp) {
            this.mrp = mrp;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder discountPrice(final BigDecimal discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder stockQuantity(final Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder isActive(final Boolean isActive) {
            this.isActive = isActive;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder sellerId(final Integer sellerId) {
            this.sellerId = sellerId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder categoryName(final String categoryName) {
            this.categoryName = categoryName;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder sellerBusinessName(final String sellerBusinessName) {
            this.sellerBusinessName = sellerBusinessName;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO.ProductResponseDTOBuilder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public ProductResponseDTO.ProductResponseDTOBuilder averageRating(final Double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public ProductResponseDTO.ProductResponseDTOBuilder soldCount(final Integer soldCount) {
            this.soldCount = soldCount;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ProductResponseDTO build() {
            return new ProductResponseDTO(this.productId, this.name, this.description, this.price, this.mrp, this.discountPrice, this.stockQuantity, this.isActive, this.sellerId, this.categoryName, this.sellerBusinessName, this.createdAt, this.updatedAt, this.imageUrl, this.averageRating, this.soldCount);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "ProductResponseDTO.ProductResponseDTOBuilder(productId=" + this.productId + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", mrp=" + this.mrp + ", discountPrice=" + this.discountPrice + ", stockQuantity=" + this.stockQuantity + ", isActive=" + this.isActive + ", categoryName=" + this.categoryName + ", sellerBusinessName=" + this.sellerBusinessName + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", imageUrl=" + this.imageUrl + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static ProductResponseDTO.ProductResponseDTOBuilder builder() {
        return new ProductResponseDTO.ProductResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getProductId() {
        return this.productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getDescription() {
        return this.description;
    }

    @java.lang.SuppressWarnings("all")
    
    public BigDecimal getPrice() {
        return this.price;
    }

    @java.lang.SuppressWarnings("all")
    
    public BigDecimal getMrp() {
        return this.mrp;
    }

    @java.lang.SuppressWarnings("all")
    
    public BigDecimal getDiscountPrice() {
        return this.discountPrice;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getStockQuantity() {
        return this.stockQuantity;
    }

    @java.lang.SuppressWarnings("all")
    
    public Boolean getIsActive() {
        return this.isActive;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getSellerId() {
        return this.sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getCategoryName() {
        return this.categoryName;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getSellerBusinessName() {
        return this.sellerBusinessName;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getImageUrl() {
        return this.imageUrl;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setDescription(final String description) {
        this.description = description;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setMrp(final BigDecimal mrp) {
        this.mrp = mrp;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setDiscountPrice(final BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setStockQuantity(final Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setSellerId(final Integer sellerId) {
        this.sellerId = sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setSellerBusinessName(final String sellerBusinessName) {
        this.sellerBusinessName = sellerBusinessName;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductResponseDTO)) return false;
        final ProductResponseDTO other = (ProductResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$stockQuantity = this.getStockQuantity();
        final java.lang.Object other$stockQuantity = other.getStockQuantity();
        if (this$stockQuantity == null ? other$stockQuantity != null : !this$stockQuantity.equals(other$stockQuantity)) return false;
        final java.lang.Object this$isActive = this.getIsActive();
        final java.lang.Object other$isActive = other.getIsActive();
        if (this$isActive == null ? other$isActive != null : !this$isActive.equals(other$isActive)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$description = this.getDescription();
        final java.lang.Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
        final java.lang.Object this$price = this.getPrice();
        final java.lang.Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final java.lang.Object this$mrp = this.getMrp();
        final java.lang.Object other$mrp = other.getMrp();
        if (this$mrp == null ? other$mrp != null : !this$mrp.equals(other$mrp)) return false;
        final java.lang.Object this$discountPrice = this.getDiscountPrice();
        final java.lang.Object other$discountPrice = other.getDiscountPrice();
        if (this$discountPrice == null ? other$discountPrice != null : !this$discountPrice.equals(other$discountPrice)) return false;
        final java.lang.Object this$categoryName = this.getCategoryName();
        final java.lang.Object other$categoryName = other.getCategoryName();
        if (this$categoryName == null ? other$categoryName != null : !this$categoryName.equals(other$categoryName)) return false;
        final java.lang.Object this$sellerBusinessName = this.getSellerBusinessName();
        final java.lang.Object other$sellerBusinessName = other.getSellerBusinessName();
        if (this$sellerBusinessName == null ? other$sellerBusinessName != null : !this$sellerBusinessName.equals(other$sellerBusinessName)) return false;
        final java.lang.Object this$createdAt = this.getCreatedAt();
        final java.lang.Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final java.lang.Object this$updatedAt = this.getUpdatedAt();
        final java.lang.Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        final java.lang.Object this$imageUrl = this.getImageUrl();
        final java.lang.Object other$imageUrl = other.getImageUrl();
        if (this$imageUrl == null ? other$imageUrl != null : !this$imageUrl.equals(other$imageUrl)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ProductResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $stockQuantity = this.getStockQuantity();
        result = result * PRIME + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
        final java.lang.Object $isActive = this.getIsActive();
        result = result * PRIME + ($isActive == null ? 43 : $isActive.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final java.lang.Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final java.lang.Object $mrp = this.getMrp();
        result = result * PRIME + ($mrp == null ? 43 : $mrp.hashCode());
        final java.lang.Object $discountPrice = this.getDiscountPrice();
        result = result * PRIME + ($discountPrice == null ? 43 : $discountPrice.hashCode());
        final java.lang.Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final java.lang.Object $sellerBusinessName = this.getSellerBusinessName();
        result = result * PRIME + ($sellerBusinessName == null ? 43 : $sellerBusinessName.hashCode());
        final java.lang.Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final java.lang.Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final java.lang.Object $imageUrl = this.getImageUrl();
        result = result * PRIME + ($imageUrl == null ? 43 : $imageUrl.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "ProductResponseDTO(productId=" + this.getProductId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", mrp=" + this.getMrp() + ", discountPrice=" + this.getDiscountPrice() + ", stockQuantity=" + this.getStockQuantity() + ", isActive=" + this.getIsActive() + ", categoryName=" + this.getCategoryName() + ", sellerBusinessName=" + this.getSellerBusinessName() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", imageUrl=" + this.getImageUrl() + ", averageRating=" + this.getAverageRating() + ", soldCount=" + this.getSoldCount() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductResponseDTO() {
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public Integer getSoldCount() {
        return this.soldCount;
    }

    public void setAverageRating(final Double averageRating) {
        this.averageRating = averageRating;
    }

    public void setSoldCount(final Integer soldCount) {
        this.soldCount = soldCount;
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductResponseDTO(final Integer productId, final String name, final String description, final BigDecimal price, final BigDecimal mrp, final BigDecimal discountPrice, final Integer stockQuantity, final Boolean isActive, final Integer sellerId, final String categoryName, final String sellerBusinessName, final LocalDateTime createdAt, final LocalDateTime updatedAt, final String imageUrl, final Double averageRating, final Integer soldCount) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.mrp = mrp;
        this.discountPrice = discountPrice;
        this.stockQuantity = stockQuantity;
        this.isActive = isActive;
        this.sellerId = sellerId;
        this.categoryName = categoryName;
        this.sellerBusinessName = sellerBusinessName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageUrl = imageUrl;
        this.averageRating = averageRating;
        this.soldCount = soldCount;
    }
}
