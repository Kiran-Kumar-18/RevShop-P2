package com.rev.app.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Integer orderId;
    private Integer userId;
    private java.time.LocalDateTime orderDate;
    private java.math.BigDecimal totalAmount;
    private String status;
    private String userName;
    private AddressResponseDTO shippingAddress;
    private AddressResponseDTO billingAddress;
    private java.util.List<OrderItemResponseDTO> items;
    private java.time.LocalDateTime statusUpdatedAt;
    private String updatedBy;

    @java.lang.SuppressWarnings("all")
    public static class OrderResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        private Integer orderId;
        @java.lang.SuppressWarnings("all")
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        private java.time.LocalDateTime orderDate;
        @java.lang.SuppressWarnings("all")
        private java.math.BigDecimal totalAmount;
        @java.lang.SuppressWarnings("all")
        private String status;
        @java.lang.SuppressWarnings("all")
        private String userName;
        @java.lang.SuppressWarnings("all")
        private AddressResponseDTO shippingAddress;
        @java.lang.SuppressWarnings("all")
        private AddressResponseDTO billingAddress;
        @java.lang.SuppressWarnings("all")
        private java.util.List<OrderItemResponseDTO> items;
        private LocalDateTime statusUpdatedAt;
        private String updatedBy;

        @java.lang.SuppressWarnings("all")
        OrderResponseDTOBuilder() {
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder orderId(final Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder orderDate(final java.time.LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder totalAmount(final java.math.BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder userName(final String userName) {
            this.userName = userName;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder shippingAddress(final AddressResponseDTO shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder billingAddress(final AddressResponseDTO billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder items(final java.util.List<OrderItemResponseDTO> items) {
            this.items = items;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder statusUpdatedAt(final java.time.LocalDateTime statusUpdatedAt) {
            this.statusUpdatedAt = statusUpdatedAt;
            return this;
        }
    

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO.OrderResponseDTOBuilder updatedBy(final String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public OrderResponseDTO build() {
            return new OrderResponseDTO(this.orderId, this.userId, this.orderDate, this.totalAmount, this.status, this.userName, this.shippingAddress, this.billingAddress, this.items, this.statusUpdatedAt, this.updatedBy);
        }
    }

    @java.lang.SuppressWarnings("all")
    public static OrderResponseDTO.OrderResponseDTOBuilder builder() {
        return new OrderResponseDTO.OrderResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public Integer getOrderId() {
        return this.orderId;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    public java.time.LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    @java.lang.SuppressWarnings("all")
    public java.math.BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    @java.lang.SuppressWarnings("all")
    public String getStatus() {
        return this.status;
    }

    @java.lang.SuppressWarnings("all")
    public String getUserName() {
        return this.userName;
    }

    @java.lang.SuppressWarnings("all")
    public AddressResponseDTO getShippingAddress() {
        return this.shippingAddress;
    }

    @java.lang.SuppressWarnings("all")
    public AddressResponseDTO getBillingAddress() {
        return this.billingAddress;
    }

    @java.lang.SuppressWarnings("all")
    public java.util.List<OrderItemResponseDTO> getItems() {
        return this.items;
    }

    @java.lang.SuppressWarnings("all")
    public LocalDateTime getStatusUpdatedAt() {
        return this.statusUpdatedAt;
    }

    @java.lang.SuppressWarnings("all")
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    @java.lang.SuppressWarnings("all")
    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }

    @java.lang.SuppressWarnings("all")
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    public void setOrderDate(final java.time.LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @java.lang.SuppressWarnings("all")
    public void setTotalAmount(final java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @java.lang.SuppressWarnings("all")
    public void setStatus(final String status) {
        this.status = status;
    }

    @java.lang.SuppressWarnings("all")
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @java.lang.SuppressWarnings("all")
    public void setShippingAddress(final AddressResponseDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @java.lang.SuppressWarnings("all")
    public void setBillingAddress(final AddressResponseDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    @java.lang.SuppressWarnings("all")
    public void setItems(final java.util.List<OrderItemResponseDTO> items) {
        this.items = items;
    }

    @java.lang.SuppressWarnings("all")
    public void setStatusUpdatedAt(final LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    @java.lang.SuppressWarnings("all")
    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @java.lang.SuppressWarnings("all")
    public OrderResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    public OrderResponseDTO(final Integer orderId, final Integer userId, final java.time.LocalDateTime orderDate, final java.math.BigDecimal totalAmount, final String status, final String userName, final AddressResponseDTO shippingAddress, final AddressResponseDTO billingAddress, final java.util.List<OrderItemResponseDTO> items, final LocalDateTime statusUpdatedAt, final String updatedBy) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.userName = userName;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.items = items;
        this.statusUpdatedAt = statusUpdatedAt;
        this.updatedBy = updatedBy;
    }
}

