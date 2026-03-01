package com.rev.app.dto;

import java.math.BigDecimal;

public class OrderItemResponseDTO {
    private Integer orderItemId;
    private Integer productId;
    private String productName;
    private String productImageUrl;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    @java.lang.SuppressWarnings("all")
    public static class OrderItemResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        private Integer orderItemId;
        @java.lang.SuppressWarnings("all")
        private Integer productId;
        @java.lang.SuppressWarnings("all")
        private String productName;
        @java.lang.SuppressWarnings("all")
        private String productImageUrl;
        @java.lang.SuppressWarnings("all")
        private Integer quantity;
        @java.lang.SuppressWarnings("all")
        private BigDecimal unitPrice;
        @java.lang.SuppressWarnings("all")
        private BigDecimal subtotal;

        @java.lang.SuppressWarnings("all")
        OrderItemResponseDTOBuilder() {
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder orderItemId(final Integer orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder productId(final Integer productId) {
            this.productId = productId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder productImageUrl(final String productImageUrl) {
            this.productImageUrl = productImageUrl;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder unitPrice(final BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO.OrderItemResponseDTOBuilder subtotal(final BigDecimal subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderItemResponseDTO build() {
            return new OrderItemResponseDTO(this.orderItemId, this.productId, this.productName, this.productImageUrl, this.quantity, this.unitPrice, this.subtotal);
        }
    }

    @java.lang.SuppressWarnings("all")
    public static OrderItemResponseDTO.OrderItemResponseDTOBuilder builder() {
        return new OrderItemResponseDTO.OrderItemResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public Integer getOrderItemId() {
        return this.orderItemId;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getProductId() {
        return this.productId;
    }

    @java.lang.SuppressWarnings("all")
    public String getProductName() {
        return this.productName;
    }

    @java.lang.SuppressWarnings("all")
    public String getProductImageUrl() {
        return this.productImageUrl;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getQuantity() {
        return this.quantity;
    }

    @java.lang.SuppressWarnings("all")
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    @java.lang.SuppressWarnings("all")
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    @java.lang.SuppressWarnings("all")
    public void setOrderItemId(final Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    @java.lang.SuppressWarnings("all")
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @java.lang.SuppressWarnings("all")
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    @java.lang.SuppressWarnings("all")
    public void setProductImageUrl(final String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @java.lang.SuppressWarnings("all")
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    @java.lang.SuppressWarnings("all")
    public void setUnitPrice(final BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @java.lang.SuppressWarnings("all")
    public void setSubtotal(final BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @java.lang.SuppressWarnings("all")
    public OrderItemResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    public OrderItemResponseDTO(final Integer orderItemId, final Integer productId, final String productName, final String productImageUrl, final Integer quantity, final BigDecimal unitPrice, final BigDecimal subtotal) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }
}
