package com.rev.app.mapper;

import com.rev.app.dto.PaymentResponseDTO;
import com.rev.app.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentResponseDTO toDto(Payment entity) {
        if (entity == null) {
            return null;
        }

        return PaymentResponseDTO.builder()
                .paymentId(entity.getPaymentId())
                .orderId(entity.getOrder() != null ? entity.getOrder().getOrderId() : null)
                .method(entity.getMethod())
                .amount(entity.getAmount())
                .paymentStatus(entity.getPaymentStatus())
                .paidAt(entity.getPaidAt())
                .build();
    }
}

