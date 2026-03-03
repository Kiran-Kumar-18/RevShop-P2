package com.rev.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_status_history")
public class OrderStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(length = 30)
    private String status;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(length = 500)
    private String remarks;

    @CreationTimestamp
    @Column(name = "updated_at", updatable = false)
    private LocalDateTime updatedAt;

    public OrderStatusHistory() {
    }

    public OrderStatusHistory(Integer historyId, Order order, String status, String updatedBy, String remarks, LocalDateTime updatedAt) {
        this.historyId = historyId;
        this.order = order;
        this.status = status;
        this.updatedBy = updatedBy;
        this.remarks = remarks;
        this.updatedAt = updatedAt;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static OrderStatusHistoryBuilder builder() {
        return new OrderStatusHistoryBuilder();
    }

    public static class OrderStatusHistoryBuilder {
        private Integer historyId;
        private Order order;
        private String status;
        private String updatedBy;
        private String remarks;
        private LocalDateTime updatedAt;

        OrderStatusHistoryBuilder() {
        }

        public OrderStatusHistoryBuilder historyId(Integer historyId) {
            this.historyId = historyId;
            return this;
        }

        public OrderStatusHistoryBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderStatusHistoryBuilder status(String status) {
            this.status = status;
            return this;
        }

        public OrderStatusHistoryBuilder updatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public OrderStatusHistoryBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public OrderStatusHistoryBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public OrderStatusHistory build() {
            return new OrderStatusHistory(historyId, order, status, updatedBy, remarks, updatedAt);
        }
    }
}
