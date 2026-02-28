package com.rev.app.service;

import com.rev.app.dto.PaymentRequestDTO;
import com.rev.app.entity.Payment;

public interface IPaymentService {
    Payment processPayment(PaymentRequestDTO request);
    Payment getPaymentByOrderId(Integer orderId);
}


