package com.rev.app.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartResponseDTO {

    private Long cartId;
    private Long userId;
    private List<CartItemResponseDTO> items;
    private BigDecimal totalMrp;
    private BigDecimal totalPriceBeforeDiscount;
    private BigDecimal totalDiscount;
    private BigDecimal totalAmount;

    public CartResponseDTO() {}

    public CartResponseDTO(Long cartId, Long userId,
                           List<CartItemResponseDTO> items,
                           BigDecimal totalMrp,
                           BigDecimal totalPriceBeforeDiscount,
                           BigDecimal totalDiscount,
                           BigDecimal totalAmount) {
        this.cartId = cartId;
        this.userId = userId;
        this.items = items;
        this.totalMrp = totalMrp;
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.totalDiscount = totalDiscount;
        this.totalAmount = totalAmount;
    }

    public static CartResponseDTOBuilder builder() {
        return new CartResponseDTOBuilder();
    }

    public Long getCartId() {   // ✅ Long
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemResponseDTO> items) {
        this.items = items;
    }

    public BigDecimal getTotalMrp() {
        return totalMrp;
    }

    public void setTotalMrp(BigDecimal totalMrp) {
        this.totalMrp = totalMrp;
    }

    public BigDecimal getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public void setTotalPriceBeforeDiscount(BigDecimal totalPriceBeforeDiscount) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static class CartResponseDTOBuilder {
        private Long cartId;
        private Long userId;
        private List<CartItemResponseDTO> items;
        private BigDecimal totalMrp;
        private BigDecimal totalPriceBeforeDiscount;
        private BigDecimal totalDiscount;
        private BigDecimal totalAmount;

        public CartResponseDTOBuilder cartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public CartResponseDTOBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public CartResponseDTOBuilder items(List<CartItemResponseDTO> items) {
            this.items = items;
            return this;
        }

        public CartResponseDTOBuilder totalMrp(BigDecimal totalMrp) {
            this.totalMrp = totalMrp;
            return this;
        }

        public CartResponseDTOBuilder totalPriceBeforeDiscount(BigDecimal totalPriceBeforeDiscount) {
            this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
            return this;
        }

        public CartResponseDTOBuilder totalDiscount(BigDecimal totalDiscount) {
            this.totalDiscount = totalDiscount;
            return this;
        }

        public CartResponseDTOBuilder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public CartResponseDTO build() {
            return new CartResponseDTO(cartId, userId, items, totalMrp, totalPriceBeforeDiscount, totalDiscount, totalAmount);
        }
    }
}