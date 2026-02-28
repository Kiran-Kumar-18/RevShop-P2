package com.rev.app.service.impl;

import com.rev.app.dto.PaymentRequestDTO;
import com.rev.app.entity.Order;
import com.rev.app.entity.Payment;
import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IOrderRepository;
import com.rev.app.repository.IPaymentRepository;
import com.rev.app.service.IPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository ipaymentRepository;
    private final IOrderRepository iorderRepository;

    @Override
    @Transactional
    public Payment processPayment(PaymentRequestDTO request) {
        if (request.getOrderId() == null) {
            throw new BadRequestException("Order ID must not be null");
        }
        Order order = iorderRepository.findById(request.getOrderId()).orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + request.getOrderId()));
        if (!order.getStatus().equalsIgnoreCase("PENDING")) {
            throw new BadRequestException("Order is already processed or cancelled. Current status: " + order.getStatus());
        }
        if (request.getAmount() == null || request.getAmount().compareTo(order.getTotalAmount()) != 0) {
            throw new BadRequestException("Payment amount does not match order total amount");
        }
        Payment payment = Payment.builder().order(order).method(request.getMethod()).amount(request.getAmount()).paymentStatus("PAID").build();
        payment = ipaymentRepository.save(payment);
        order.setStatus("PAID");
        iorderRepository.save(order);
        return payment;
    }

    @Override
    public Payment getPaymentByOrderId(Integer orderId) {
        return ipaymentRepository.findByOrderOrderId(orderId).orElseThrow(() -> new ResourceNotFoundException("Payment not found for order id: " + orderId));
    }

    @java.lang.SuppressWarnings("all")
    
    public PaymentServiceImpl(final IPaymentRepository ipaymentRepository, final IOrderRepository iorderRepository) {
        this.ipaymentRepository = ipaymentRepository;
        this.iorderRepository = iorderRepository;
    }
}
