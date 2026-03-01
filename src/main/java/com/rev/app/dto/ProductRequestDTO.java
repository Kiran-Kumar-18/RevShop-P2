package com.rev.app.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequestDTO {
    @NotBlank(message = "Product name is required")
    @Size(max = 150)
    private String name;
    private String description;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;
    @DecimalMin(value = "0.0", message = "MRP must be greater than or equal to zero")
    private BigDecimal mrp;
    private BigDecimal discountPrice;
    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private Integer stockQuantity;
    private Integer stockThreshold;
    @NotNull(message = "Category ID is required")
    private Integer categoryId;
    @NotNull(message = "Seller ID is required")
    private Integer sellerId;
    private Boolean isActive;
    private String imageUrl;


    @java.lang.SuppressWarnings("all")
    
    public static class ProductRequestDTOBuilder {
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
        
        private Integer stockThreshold;
        @java.lang.SuppressWarnings("all")
        
        private Integer categoryId;
        @java.lang.SuppressWarnings("all")
        
        private Integer sellerId;
        @java.lang.SuppressWarnings("all")
        
        private Boolean isActive;
        @java.lang.SuppressWarnings("all")
        
        private String imageUrl;

        @java.lang.SuppressWarnings("all")
        
        ProductRequestDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder description(final String description) {
            this.description = description;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder price(final BigDecimal price) {
            this.price = price;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder mrp(final BigDecimal mrp) {
            this.mrp = mrp;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder discountPrice(final BigDecimal discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder stockQuantity(final Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder stockThreshold(final Integer stockThreshold) {
            this.stockThreshold = stockThreshold;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder categoryId(final Integer categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder sellerId(final Integer sellerId) {
            this.sellerId = sellerId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder isActive(final Boolean isActive) {
            this.isActive = isActive;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO.ProductRequestDTOBuilder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public ProductRequestDTO build() {
            return new ProductRequestDTO(this.name, this.description, this.price, this.mrp, this.discountPrice, this.stockQuantity, this.stockThreshold, this.categoryId, this.sellerId, this.isActive, this.imageUrl);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "ProductRequestDTO.ProductRequestDTOBuilder(name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", mrp=" + this.mrp + ", discountPrice=" + this.discountPrice + ", stockQuantity=" + this.stockQuantity + ", stockThreshold=" + this.stockThreshold + ", categoryId=" + this.categoryId + ", sellerId=" + this.sellerId + ", isActive=" + this.isActive + ", imageUrl=" + this.imageUrl + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static ProductRequestDTO.ProductRequestDTOBuilder builder() {
        return new ProductRequestDTO.ProductRequestDTOBuilder();
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
    
    public Integer getStockThreshold() {
        return this.stockThreshold;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getCategoryId() {
        return this.categoryId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getSellerId() {
        return this.sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Boolean getIsActive() {
        return this.isActive;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getImageUrl() {
        return this.imageUrl;
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
    
    public void setStockThreshold(final Integer stockThreshold) {
        this.stockThreshold = stockThreshold;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setSellerId(final Integer sellerId) {
        this.sellerId = sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductRequestDTO)) return false;
        final ProductRequestDTO other = (ProductRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$stockQuantity = this.getStockQuantity();
        final java.lang.Object other$stockQuantity = other.getStockQuantity();
        if (this$stockQuantity == null ? other$stockQuantity != null : !this$stockQuantity.equals(other$stockQuantity)) return false;
        final java.lang.Object this$stockThreshold = this.getStockThreshold();
        final java.lang.Object other$stockThreshold = other.getStockThreshold();
        if (this$stockThreshold == null ? other$stockThreshold != null : !this$stockThreshold.equals(other$stockThreshold)) return false;
        final java.lang.Object this$categoryId = this.getCategoryId();
        final java.lang.Object other$categoryId = other.getCategoryId();
        if (this$categoryId == null ? other$categoryId != null : !this$categoryId.equals(other$categoryId)) return false;
        final java.lang.Object this$sellerId = this.getSellerId();
        final java.lang.Object other$sellerId = other.getSellerId();
        if (this$sellerId == null ? other$sellerId != null : !this$sellerId.equals(other$sellerId)) return false;
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
        final java.lang.Object this$imageUrl = this.getImageUrl();
        final java.lang.Object other$imageUrl = other.getImageUrl();
        if (this$imageUrl == null ? other$imageUrl != null : !this$imageUrl.equals(other$imageUrl)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ProductRequestDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $stockQuantity = this.getStockQuantity();
        result = result * PRIME + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
        final java.lang.Object $stockThreshold = this.getStockThreshold();
        result = result * PRIME + ($stockThreshold == null ? 43 : $stockThreshold.hashCode());
        final java.lang.Object $categoryId = this.getCategoryId();
        result = result * PRIME + ($categoryId == null ? 43 : $categoryId.hashCode());
        final java.lang.Object $sellerId = this.getSellerId();
        result = result * PRIME + ($sellerId == null ? 43 : $sellerId.hashCode());
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
        final java.lang.Object $imageUrl = this.getImageUrl();
        result = result * PRIME + ($imageUrl == null ? 43 : $imageUrl.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "ProductRequestDTO(name=" + this.getName() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", mrp=" + this.getMrp() + ", discountPrice=" + this.getDiscountPrice() + ", stockQuantity=" + this.getStockQuantity() + ", stockThreshold=" + this.getStockThreshold() + ", categoryId=" + this.getCategoryId() + ", sellerId=" + this.getSellerId() + ", isActive=" + this.getIsActive() + ", imageUrl=" + this.getImageUrl() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductRequestDTO(final String name, final String description, final BigDecimal price, final BigDecimal mrp, final BigDecimal discountPrice, final Integer stockQuantity, final Integer stockThreshold, final Integer categoryId, final Integer sellerId, final Boolean isActive, final String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.mrp = mrp;
        this.discountPrice = discountPrice;
        this.stockQuantity = stockQuantity;
        this.stockThreshold = stockThreshold;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
    }
}
