package com.rev.app.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;
    @CreationTimestamp
    @Column(name = "order_date", updatable = false)
    private LocalDateTime orderDate;
    @Column(name = "total_amount", precision = 12, scale = 2)
    private BigDecimal totalAmount;
    @Column(length = 30)
    private String status;
    @Column(name = "status_updated_at")
    private LocalDateTime statusUpdatedAt;
    @Column(name = "updated_by")
    private String updatedBy;


    @java.lang.SuppressWarnings("all")
    
    public static class OrderBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer orderId;
        @java.lang.SuppressWarnings("all")
        
        private User user;
        @java.lang.SuppressWarnings("all")
        
        private Address shippingAddress;
        @java.lang.SuppressWarnings("all")
        
        private Address billingAddress;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime orderDate;
        @java.lang.SuppressWarnings("all")
        
        private BigDecimal totalAmount;
        @java.lang.SuppressWarnings("all")
        
        private String status;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime statusUpdatedAt;
        @java.lang.SuppressWarnings("all")
        
        private String updatedBy;

        @java.lang.SuppressWarnings("all")
        
        OrderBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder orderId(final Integer orderId) {
            this.orderId = orderId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder user(final User user) {
            this.user = user;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder shippingAddress(final Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder billingAddress(final Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder orderDate(final LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder totalAmount(final BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder status(final String status) {
            this.status = status;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder statusUpdatedAt(final LocalDateTime statusUpdatedAt) {
            this.statusUpdatedAt = statusUpdatedAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Order.OrderBuilder updatedBy(final String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Order build() {
            return new Order(this.orderId, this.user, this.shippingAddress, this.billingAddress, this.orderDate, this.totalAmount, this.status, this.statusUpdatedAt, this.updatedBy);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "Order.OrderBuilder(orderId=" + this.orderId + ", user=" + this.user + ", shippingAddress=" + this.shippingAddress + ", billingAddress=" + this.billingAddress + ", orderDate=" + this.orderDate + ", totalAmount=" + this.totalAmount + ", status=" + this.status + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static Order.OrderBuilder builder() {
        return new Order.OrderBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getOrderId() {
        return this.orderId;
    }

    @java.lang.SuppressWarnings("all")
    
    public User getUser() {
        return this.user;
    }

    @java.lang.SuppressWarnings("all")
    
    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    @java.lang.SuppressWarnings("all")
    
    public Address getBillingAddress() {
        return this.billingAddress;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    @java.lang.SuppressWarnings("all")
    
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getStatus() {
        return this.status;
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
    
    public void setUser(final User user) {
        this.user = user;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setShippingAddress(final Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setBillingAddress(final Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setOrderDate(final LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setStatus(final String status) {
        this.status = status;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setStatusUpdatedAt(final LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$orderId = this.getOrderId();
        final java.lang.Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final java.lang.Object this$user = this.getUser();
        final java.lang.Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final java.lang.Object this$shippingAddress = this.getShippingAddress();
        final java.lang.Object other$shippingAddress = other.getShippingAddress();
        if (this$shippingAddress == null ? other$shippingAddress != null : !this$shippingAddress.equals(other$shippingAddress)) return false;
        final java.lang.Object this$billingAddress = this.getBillingAddress();
        final java.lang.Object other$billingAddress = other.getBillingAddress();
        if (this$billingAddress == null ? other$billingAddress != null : !this$billingAddress.equals(other$billingAddress)) return false;
        final java.lang.Object this$orderDate = this.getOrderDate();
        final java.lang.Object other$orderDate = other.getOrderDate();
        if (this$orderDate == null ? other$orderDate != null : !this$orderDate.equals(other$orderDate)) return false;
        final java.lang.Object this$totalAmount = this.getTotalAmount();
        final java.lang.Object other$totalAmount = other.getTotalAmount();
        if (this$totalAmount == null ? other$totalAmount != null : !this$totalAmount.equals(other$totalAmount)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final java.lang.Object this$statusUpdatedAt = this.getStatusUpdatedAt();
        final java.lang.Object other$statusUpdatedAt = other.getStatusUpdatedAt();
        if (this$statusUpdatedAt == null ? other$statusUpdatedAt != null : !this$statusUpdatedAt.equals(other$statusUpdatedAt)) return false;
        final java.lang.Object this$updatedBy = this.getUpdatedBy();
        final java.lang.Object other$updatedBy = other.getUpdatedBy();
        if (this$updatedBy == null ? other$updatedBy != null : !this$updatedBy.equals(other$updatedBy)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Order;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final java.lang.Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final java.lang.Object $shippingAddress = this.getShippingAddress();
        result = result * PRIME + ($shippingAddress == null ? 43 : $shippingAddress.hashCode());
        final java.lang.Object $billingAddress = this.getBillingAddress();
        result = result * PRIME + ($billingAddress == null ? 43 : $billingAddress.hashCode());
        final java.lang.Object $orderDate = this.getOrderDate();
        result = result * PRIME + ($orderDate == null ? 43 : $orderDate.hashCode());
        final java.lang.Object $totalAmount = this.getTotalAmount();
        result = result * PRIME + ($totalAmount == null ? 43 : $totalAmount.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final java.lang.Object $statusUpdatedAt = this.getStatusUpdatedAt();
        result = result * PRIME + ($statusUpdatedAt == null ? 43 : $statusUpdatedAt.hashCode());
        final java.lang.Object $updatedBy = this.getUpdatedBy();
        result = result * PRIME + ($updatedBy == null ? 43 : $updatedBy.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "Order(orderId=" + this.getOrderId() + ", user=" + this.getUser() + ", shippingAddress=" + this.getShippingAddress() + ", billingAddress=" + this.getBillingAddress() + ", orderDate=" + this.getOrderDate() + ", totalAmount=" + this.getTotalAmount() + ", status=" + this.getStatus() + ", statusUpdatedAt=" + this.getStatusUpdatedAt() + ", updatedBy=" + this.getUpdatedBy() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public Order() {
    }

    @java.lang.SuppressWarnings("all")
    
    public Order(final Integer orderId, final User user, final Address shippingAddress, final Address billingAddress, final LocalDateTime orderDate, final BigDecimal totalAmount, final String status, final LocalDateTime statusUpdatedAt, final String updatedBy) {
        this.orderId = orderId;
        this.user = user;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.statusUpdatedAt = statusUpdatedAt;
        this.updatedBy = updatedBy;
    }
}
