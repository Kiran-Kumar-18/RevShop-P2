package com.rev.app.dto;

import java.math.BigDecimal;

public class CartItemResponseDTO {
    private Integer cartItemId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal mrp;
    private BigDecimal discountPrice;
    private BigDecimal itemDiscount;
    private BigDecimal itemTotal;
    private String productImageUrl;

    @java.lang.SuppressWarnings("all")
    public static class CartItemResponseDTOBuilder {
        private Integer cartItemId;
        private Integer productId;
        private String productName;
        private Integer quantity;
        private BigDecimal price;
        private BigDecimal mrp;
        private BigDecimal discountPrice;
        private BigDecimal itemDiscount;
        private BigDecimal itemTotal;
        private String productImageUrl;

        CartItemResponseDTOBuilder() {
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder cartItemId(final Integer cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder mrp(final BigDecimal mrp) {
            this.mrp = mrp;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder discountPrice(final BigDecimal discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder itemDiscount(final BigDecimal itemDiscount) {
            this.itemDiscount = itemDiscount;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder itemTotal(final BigDecimal itemTotal) {
            this.itemTotal = itemTotal;
            return this;
        }

        public CartItemResponseDTO.CartItemResponseDTOBuilder productImageUrl(final String productImageUrl) {
            this.productImageUrl = productImageUrl;
            return this;
        }

        public CartItemResponseDTO build() {
            return new CartItemResponseDTO(this.cartItemId, this.productId, this.productName, this.quantity, this.price, this.mrp, this.discountPrice, this.itemDiscount, this.itemTotal, this.productImageUrl);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "CartItemResponseDTO.CartItemResponseDTOBuilder(cartItemId=" + this.cartItemId + ", productId=" + this.productId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", price=" + this.price + ", mrp=" + this.mrp + ", discountPrice=" + this.discountPrice + ", itemDiscount=" + this.itemDiscount + ", itemTotal=" + this.itemTotal + ", productImageUrl=" + this.productImageUrl + ")";
        }
    }

    public static CartItemResponseDTO.CartItemResponseDTOBuilder builder() {
        return new CartItemResponseDTO.CartItemResponseDTOBuilder();
    }

    public Integer getCartItemId() { return this.cartItemId; }
    public Integer getProductId() { return this.productId; }
    public String getProductName() { return this.productName; }
    public Integer getQuantity() { return this.quantity; }
    public BigDecimal getPrice() { return this.price; }
    public BigDecimal getMrp() { return this.mrp; }
    public BigDecimal getDiscountPrice() { return this.discountPrice; }
    public BigDecimal getItemDiscount() { return this.itemDiscount; }
    public BigDecimal getItemTotal() { return this.itemTotal; }
    public String getProductImageUrl() { return this.productImageUrl; }

    public void setCartItemId(final Integer cartItemId) { this.cartItemId = cartItemId; }
    public void setProductId(final Integer productId) { this.productId = productId; }
    public void setProductName(final String productName) { this.productName = productName; }
    public void setQuantity(final Integer quantity) { this.quantity = quantity; }
    public void setPrice(final BigDecimal price) { this.price = price; }
    public void setMrp(final BigDecimal mrp) { this.mrp = mrp; }
    public void setDiscountPrice(final BigDecimal discountPrice) { this.discountPrice = discountPrice; }
    public void setItemDiscount(final BigDecimal itemDiscount) { this.itemDiscount = itemDiscount; }
    public void setItemTotal(final BigDecimal itemTotal) { this.itemTotal = itemTotal; }
    public void setProductImageUrl(final String productImageUrl) { this.productImageUrl = productImageUrl; }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CartItemResponseDTO)) return false;
        final CartItemResponseDTO other = (CartItemResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$cartItemId = this.getCartItemId();
        final java.lang.Object other$cartItemId = other.getCartItemId();
        if (this$cartItemId == null ? other$cartItemId != null : !this$cartItemId.equals(other$cartItemId)) return false;
        final java.lang.Object this$productId = this.getProductId();
        final java.lang.Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final java.lang.Object this$quantity = this.getQuantity();
        final java.lang.Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final java.lang.Object this$productName = this.getProductName();
        final java.lang.Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) return false;
        final java.lang.Object this$price = this.getPrice();
        final java.lang.Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final java.lang.Object this$mrp = this.getMrp();
        final java.lang.Object other$mrp = other.getMrp();
        if (this$mrp == null ? other$mrp != null : !this$mrp.equals(other$mrp)) return false;
        final java.lang.Object this$discountPrice = this.getDiscountPrice();
        final java.lang.Object other$discountPrice = other.getDiscountPrice();
        if (this$discountPrice == null ? other$discountPrice != null : !this$discountPrice.equals(other$discountPrice)) return false;
        final java.lang.Object this$itemDiscount = this.getItemDiscount();
        final java.lang.Object other$itemDiscount = other.getItemDiscount();
        if (this$itemDiscount == null ? other$itemDiscount != null : !this$itemDiscount.equals(other$itemDiscount)) return false;
        final java.lang.Object this$itemTotal = this.getItemTotal();
        final java.lang.Object other$itemTotal = other.getItemTotal();
        if (this$itemTotal == null ? other$itemTotal != null : !this$itemTotal.equals(other$itemTotal)) return false;
        final java.lang.Object this$productImageUrl = this.getProductImageUrl();
        final java.lang.Object other$productImageUrl = other.getProductImageUrl();
        if (this$productImageUrl == null ? other$productImageUrl != null : !this$productImageUrl.equals(other$productImageUrl)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CartItemResponseDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $cartItemId = this.getCartItemId();
        result = result * PRIME + ($cartItemId == null ? 43 : $cartItemId.hashCode());
        final java.lang.Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final java.lang.Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final java.lang.Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final java.lang.Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final java.lang.Object $mrp = this.getMrp();
        result = result * PRIME + ($mrp == null ? 43 : $mrp.hashCode());
        final java.lang.Object $discountPrice = this.getDiscountPrice();
        result = result * PRIME + ($discountPrice == null ? 43 : $discountPrice.hashCode());
        final java.lang.Object $itemDiscount = this.getItemDiscount();
        result = result * PRIME + ($itemDiscount == null ? 43 : $itemDiscount.hashCode());
        final java.lang.Object $itemTotal = this.getItemTotal();
        result = result * PRIME + ($itemTotal == null ? 43 : $itemTotal.hashCode());
        final java.lang.Object $productImageUrl = this.getProductImageUrl();
        result = result * PRIME + ($productImageUrl == null ? 43 : $productImageUrl.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CartItemResponseDTO(cartItemId=" + this.getCartItemId() + ", productId=" + this.getProductId() + ", productName=" + this.getProductName() + ", quantity=" + this.getQuantity() + ", price=" + this.getPrice() + ", mrp=" + this.getMrp() + ", discountPrice=" + this.getDiscountPrice() + ", itemDiscount=" + this.getItemDiscount() + ", itemTotal=" + this.getItemTotal() + ", productImageUrl=" + this.getProductImageUrl() + ")";
    }

    public CartItemResponseDTO() {
    }

    public CartItemResponseDTO(final Integer cartItemId, final Integer productId, final String productName, final Integer quantity, final BigDecimal price, final BigDecimal mrp, final BigDecimal discountPrice, final BigDecimal itemDiscount, final BigDecimal itemTotal, final String productImageUrl) {
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.mrp = mrp;
        this.discountPrice = discountPrice;
        this.itemDiscount = itemDiscount;
        this.itemTotal = itemTotal;
        this.productImageUrl = productImageUrl;
    }
}
