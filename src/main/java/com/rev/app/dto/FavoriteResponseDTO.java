package com.rev.app.dto;

public class FavoriteResponseDTO {
    private Integer favoriteId;
    private Integer userId;
    private Integer productId;
    private String productName;
    private String imageUrl;
    private java.math.BigDecimal price;
    private java.math.BigDecimal mrp;
    private String categoryName;


    @java.lang.SuppressWarnings("all")
    
    public static class FavoriteResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer favoriteId;
        @java.lang.SuppressWarnings("all")
        
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        
        private String productName;
        private String imageUrl;
        private java.math.BigDecimal price;
        private java.math.BigDecimal mrp;
        private String categoryName;

        @java.lang.SuppressWarnings("all")
        
        FavoriteResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public FavoriteResponseDTO.FavoriteResponseDTOBuilder favoriteId(final Integer favoriteId) {
            this.favoriteId = favoriteId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public FavoriteResponseDTO.FavoriteResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public FavoriteResponseDTO.FavoriteResponseDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public FavoriteResponseDTO.FavoriteResponseDTOBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        public FavoriteResponseDTO.FavoriteResponseDTOBuilder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public FavoriteResponseDTO.FavoriteResponseDTOBuilder price(final java.math.BigDecimal price) {
            this.price = price;
            return this;
        }

        public FavoriteResponseDTO.FavoriteResponseDTOBuilder mrp(final java.math.BigDecimal mrp) {
            this.mrp = mrp;
            return this;
        }

        public FavoriteResponseDTO.FavoriteResponseDTOBuilder categoryName(final String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public FavoriteResponseDTO build() {
            return new FavoriteResponseDTO(this.favoriteId, this.userId, this.productId, this.productName, this.imageUrl, this.price, this.mrp, this.categoryName);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "FavoriteResponseDTO.FavoriteResponseDTOBuilder(favoriteId=" + this.favoriteId + ", userId=" + this.userId + ", productId=" + this.productId + ", productName=" + this.productName + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static FavoriteResponseDTO.FavoriteResponseDTOBuilder builder() {
        return new FavoriteResponseDTO.FavoriteResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getFavoriteId() {
        return this.favoriteId;
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
    
    public String getProductName() {
        return this.productName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public java.math.BigDecimal getPrice() {
        return this.price;
    }

    public java.math.BigDecimal getMrp() {
        return this.mrp;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setFavoriteId(final Integer favoriteId) {
        this.favoriteId = favoriteId;
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
    
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(final java.math.BigDecimal price) {
        this.price = price;
    }

    public void setMrp(final java.math.BigDecimal mrp) {
        this.mrp = mrp;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof FavoriteResponseDTO)) return false;
        final FavoriteResponseDTO other = (FavoriteResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$favoriteId = this.getFavoriteId();
        final java.lang.Object other$favoriteId = other.getFavoriteId();
        if (this$favoriteId == null ? other$favoriteId != null : !this$favoriteId.equals(other$favoriteId)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$productName = this.getProductName();
        final java.lang.Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof FavoriteResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $favoriteId = this.getFavoriteId();
        result = result * PRIME + ($favoriteId == null ? 43 : $favoriteId.hashCode());
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "FavoriteResponseDTO(favoriteId=" + this.getFavoriteId() + ", userId=" + this.getUserId() + ", productId=" + this.getProductId() + ", productName=" + this.getProductName() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public FavoriteResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public FavoriteResponseDTO(final Integer favoriteId, final Integer userId, final Integer productId, final String productName, final String imageUrl, final java.math.BigDecimal price, final java.math.BigDecimal mrp, final String categoryName) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.mrp = mrp;
        this.categoryName = categoryName;
    }
}
