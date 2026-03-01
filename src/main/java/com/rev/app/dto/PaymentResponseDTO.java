package com.rev.app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDTO {
    private Integer paymentId;
    private Integer orderId;
    private String method;
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDateTime paidAt;


    @java.lang.SuppressWarnings("all")
    
    public static class PaymentResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer paymentId;
        @java.lang.SuppressWarnings("all")
        
        private Integer orderId;
        @java.lang.SuppressWarnings("all")
        
        private String method;
        @java.lang.SuppressWarnings("all")
        
        private BigDecimal amount;
        @java.lang.SuppressWarnings("all")
        
        private String paymentStatus;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime paidAt;

        @java.lang.SuppressWarnings("all")
        
        PaymentResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder paymentId(final Integer paymentId) {
            this.paymentId = paymentId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder orderId(final Integer orderId) {
            this.orderId = orderId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder method(final String method) {
            this.method = method;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder amount(final BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder paymentStatus(final String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO.PaymentResponseDTOBuilder paidAt(final LocalDateTime paidAt) {
            this.paidAt = paidAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public PaymentResponseDTO build() {
            return new PaymentResponseDTO(this.paymentId, this.orderId, this.method, this.amount, this.paymentStatus, this.paidAt);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "PaymentResponseDTO.PaymentResponseDTOBuilder(paymentId=" + this.paymentId + ", orderId=" + this.orderId + ", method=" + this.method + ", amount=" + this.amount + ", paymentStatus=" + this.paymentStatus + ", paidAt=" + this.paidAt + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static PaymentResponseDTO.PaymentResponseDTOBuilder builder() {
        return new PaymentResponseDTO.PaymentResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getPaymentId() {
        return this.paymentId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getOrderId() {
        return this.orderId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getMethod() {
        return this.method;
    }

    @java.lang.SuppressWarnings("all")
    
    public BigDecimal getAmount() {
        return this.amount;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getPaidAt() {
        return this.paidAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setMethod(final String method) {
        this.method = method;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPaymentStatus(final String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPaidAt(final LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof PaymentResponseDTO)) return false;
        final PaymentResponseDTO other = (PaymentResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$paymentId = this.getPaymentId();
        final java.lang.Object other$paymentId = other.getPaymentId();
        if (this$paymentId == null ? other$paymentId != null : !this$paymentId.equals(other$paymentId)) return false;
        final java.lang.Object this$orderId = this.getOrderId();
        final java.lang.Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final java.lang.Object this$method = this.getMethod();
        final java.lang.Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) return false;
        final java.lang.Object this$amount = this.getAmount();
        final java.lang.Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        final java.lang.Object this$paymentStatus = this.getPaymentStatus();
        final java.lang.Object other$paymentStatus = other.getPaymentStatus();
        if (this$paymentStatus == null ? other$paymentStatus != null : !this$paymentStatus.equals(other$paymentStatus)) return false;
        final java.lang.Object this$paidAt = this.getPaidAt();
        final java.lang.Object other$paidAt = other.getPaidAt();
        if (this$paidAt == null ? other$paidAt != null : !this$paidAt.equals(other$paidAt)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof PaymentResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $paymentId = this.getPaymentId();
        result = result * PRIME + ($paymentId == null ? 43 : $paymentId.hashCode());
        final java.lang.Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final java.lang.Object $method = this.getMethod();
        result = result * PRIME + ($method == null ? 43 : $method.hashCode());
        final java.lang.Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        final java.lang.Object $paymentStatus = this.getPaymentStatus();
        result = result * PRIME + ($paymentStatus == null ? 43 : $paymentStatus.hashCode());
        final java.lang.Object $paidAt = this.getPaidAt();
        result = result * PRIME + ($paidAt == null ? 43 : $paidAt.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "PaymentResponseDTO(paymentId=" + this.getPaymentId() + ", orderId=" + this.getOrderId() + ", method=" + this.getMethod() + ", amount=" + this.getAmount() + ", paymentStatus=" + this.getPaymentStatus() + ", paidAt=" + this.getPaidAt() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public PaymentResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public PaymentResponseDTO(final Integer paymentId, final Integer orderId, final String method, final BigDecimal amount, final String paymentStatus, final LocalDateTime paidAt) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.method = method;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paidAt = paidAt;
    }
}
