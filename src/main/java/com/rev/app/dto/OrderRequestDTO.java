package com.rev.app.dto;

import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {
    @NotNull(message = "User ID is required")
    private Integer userId;
    @NotNull(message = "Shipping address ID is required")
    private Integer shippingAddressId;
    @NotNull(message = "Billing address ID is required")
    private Integer billingAddressId;


    @java.lang.SuppressWarnings("all")
    
    public static class OrderRequestDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private Integer shippingAddressId;
        @java.lang.SuppressWarnings("all")
        
        private Integer billingAddressId;

        @java.lang.SuppressWarnings("all")
        
        OrderRequestDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public OrderRequestDTO.OrderRequestDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public OrderRequestDTO.OrderRequestDTOBuilder shippingAddressId(final Integer shippingAddressId) {
            this.shippingAddressId = shippingAddressId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public OrderRequestDTO.OrderRequestDTOBuilder billingAddressId(final Integer billingAddressId) {
            this.billingAddressId = billingAddressId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public OrderRequestDTO build() {
            return new OrderRequestDTO(this.userId, this.shippingAddressId, this.billingAddressId);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "OrderRequestDTO.OrderRequestDTOBuilder(userId=" + this.userId + ", shippingAddressId=" + this.shippingAddressId + ", billingAddressId=" + this.billingAddressId + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static OrderRequestDTO.OrderRequestDTOBuilder builder() {
        return new OrderRequestDTO.OrderRequestDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getShippingAddressId() {
        return this.shippingAddressId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getBillingAddressId() {
        return this.billingAddressId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setShippingAddressId(final Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setBillingAddressId(final Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderRequestDTO)) return false;
        final OrderRequestDTO other = (OrderRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$shippingAddressId = this.getShippingAddressId();
        final java.lang.Object other$shippingAddressId = other.getShippingAddressId();
        if (this$shippingAddressId == null ? other$shippingAddressId != null : !this$shippingAddressId.equals(other$shippingAddressId)) return false;
        final java.lang.Object this$billingAddressId = this.getBillingAddressId();
        final java.lang.Object other$billingAddressId = other.getBillingAddressId();
        if (this$billingAddressId == null ? other$billingAddressId != null : !this$billingAddressId.equals(other$billingAddressId)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof OrderRequestDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $shippingAddressId = this.getShippingAddressId();
        result = result * PRIME + ($shippingAddressId == null ? 43 : $shippingAddressId.hashCode());
        final java.lang.Object $billingAddressId = this.getBillingAddressId();
        result = result * PRIME + ($billingAddressId == null ? 43 : $billingAddressId.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "OrderRequestDTO(userId=" + this.getUserId() + ", shippingAddressId=" + this.getShippingAddressId() + ", billingAddressId=" + this.getBillingAddressId() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public OrderRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public OrderRequestDTO(final Integer userId, final Integer shippingAddressId, final Integer billingAddressId) {
        this.userId = userId;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
    }
}
