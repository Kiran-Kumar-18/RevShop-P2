package com.rev.app.service.impl;

import com.rev.app.dto.PaymentRequestDTO;
import com.rev.app.entity.*;
import com.rev.app.exception.*;
import com.rev.app.repository.*;
import com.rev.app.service.IPaymentService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class);
    private final IPaymentRepository ipaymentRepository;
    private final IOrderRepository iorderRepository;
    private final IOrderItemRepository iorderItemRepository;
    private final ISellerRepository isellerRepository;

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
            logger.warn("Payment attempt with mismatched amount. Order ID: {}, Request Amount: {}, Order Amount: {}", request.getOrderId(), request.getAmount(), order.getTotalAmount());
            throw new BadRequestException("Payment amount does not match order total amount");
        }
        Optional<Payment> existingPayment = ipaymentRepository.findByOrderOrderId(order.getOrderId());
        boolean isCod = existingPayment.map(p -> "COD".equalsIgnoreCase(p.getMethod())).orElse(false);

        Payment payment;
        if (existingPayment.isPresent()) {
            payment = existingPayment.get();
            payment.setPaymentStatus("PAID");
            payment.setPaidAt(java.time.LocalDateTime.now());
            ipaymentRepository.save(payment);
        } else {
            payment = Payment.builder()
                .order(order)
                .method(request.getMethod())
                .amount(request.getAmount())
                .paymentStatus("PAID")
                .paidAt(java.time.LocalDateTime.now())
                .build();
            payment = ipaymentRepository.save(payment);
        }

        // Update Order status
        order.setStatus("PAID");
        iorderRepository.save(order);
        logger.info("Payment processed successfully for Order ID: {} with method: {}. Amount: {}", order.getOrderId(), request.getMethod(), request.getAmount());
        
        // Add revenue only for non-COD payments (COD added later on Shipped/Delivered)
        if (!isCod) {
            List<OrderItem> items = iorderItemRepository.findByOrderOrderId(order.getOrderId());
            for (OrderItem item : items) {
                Seller seller = item.getSeller();
                if (seller != null) {
                    BigDecimal rev = seller.getTotalRevenue() != null ? seller.getTotalRevenue() : BigDecimal.ZERO;
                    seller.setTotalRevenue(rev.add(item.getSubtotal()));
                    isellerRepository.save(seller);
                    logger.debug("Revenue {} added to seller {} (Order #{})", item.getSubtotal(), seller.getBusinessName(), order.getOrderId());
                }
            }
        }

        return payment;
    }

    @Override
    public Payment getPaymentByOrderId(Integer orderId) {
        return ipaymentRepository.findByOrderOrderId(orderId).orElseThrow(() -> new ResourceNotFoundException("Payment not found for order id: " + orderId));
    }

    @java.lang.SuppressWarnings("all")
    
    public PaymentServiceImpl(final IPaymentRepository ipaymentRepository, final IOrderRepository iorderRepository, final IOrderItemRepository iorderItemRepository, final ISellerRepository isellerRepository) {
        this.ipaymentRepository = ipaymentRepository;
        this.iorderRepository = iorderRepository;
        this.iorderItemRepository = iorderItemRepository;
        this.isellerRepository = isellerRepository;
    }
}
