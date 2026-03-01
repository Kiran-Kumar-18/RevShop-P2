package com.rev.app.dto;

import jakarta.validation.constraints.NotNull;

public class CartRequestDTO {
    @NotNull(message = "Product ID is required")
    private Integer productId;
    @NotNull(message = "Quantity is required")
    private Integer quantity;


    @java.lang.SuppressWarnings("all")
    
    public static class CartRequestDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        
        private Integer quantity;

        @java.lang.SuppressWarnings("all")
        
        CartRequestDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public CartRequestDTO.CartRequestDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public CartRequestDTO.CartRequestDTOBuilder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public CartRequestDTO build() {
            return new CartRequestDTO(this.productId, this.quantity);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "CartRequestDTO.CartRequestDTOBuilder(productId=" + this.productId + ", quantity=" + this.quantity + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static CartRequestDTO.CartRequestDTOBuilder builder() {
        return new CartRequestDTO.CartRequestDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getProductId() {
        return this.productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getQuantity() {
        return this.quantity;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CartRequestDTO)) return false;
        final CartRequestDTO other = (CartRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$quantity = this.getQuantity();
        final java.lang.Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CartRequestDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "CartRequestDTO(productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public CartRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public CartRequestDTO(final Integer productId, final Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
