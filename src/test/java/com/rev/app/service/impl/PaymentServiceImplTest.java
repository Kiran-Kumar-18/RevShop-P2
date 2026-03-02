package com.rev.app.service.impl;

import com.rev.app.dto.PaymentRequestDTO;
import com.rev.app.entity.Order;
import com.rev.app.entity.Payment;
import com.rev.app.entity.OrderItem;
import com.rev.app.entity.Seller;
import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IOrderRepository;
import com.rev.app.repository.IPaymentRepository;
import com.rev.app.repository.IOrderItemRepository;
import com.rev.app.repository.ISellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {

    @Mock
    private IPaymentRepository paymentRepository;
    @Mock
    private IOrderRepository orderRepository;
    @Mock
    private IOrderItemRepository orderItemRepository;
    @Mock
    private ISellerRepository sellerRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Order order;
    private PaymentRequestDTO paymentRequest;

    @BeforeEach
    void setUp() {
        order = Order.builder()
                .orderId(1)
                .totalAmount(new BigDecimal("100.00"))
                .status("PENDING")
                .build();

        paymentRequest = new PaymentRequestDTO();
        paymentRequest.setOrderId(1);
        paymentRequest.setAmount(new BigDecimal("100.00"));
        paymentRequest.setMethod("CREDIT_CARD");
    }

    @Test
    void processPayment_Success() {
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));
        when(paymentRepository.findByOrderOrderId(1)).thenReturn(Optional.empty());
        when(paymentRepository.save(any(Payment.class))).thenAnswer(i -> i.getArguments()[0]);
        when(orderItemRepository.findByOrderOrderId(1)).thenReturn(Collections.emptyList());

        Payment result = paymentService.processPayment(paymentRequest);

        assertNotNull(result);
        assertEquals("PAID", result.getPaymentStatus());
        assertEquals("PAID", order.getStatus());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void processPayment_OrderNotFound() {
        when(orderRepository.findById(99)).thenReturn(Optional.empty());
        paymentRequest.setOrderId(99);

        assertThrows(ResourceNotFoundException.class, () -> paymentService.processPayment(paymentRequest));
    }

    @Test
    void processPayment_OrderAlreadyProcessed() {
        order.setStatus("SHIPPED");
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        assertThrows(BadRequestException.class, () -> paymentService.processPayment(paymentRequest));
    }

    @Test
    void processPayment_AmountMismatch() {
        paymentRequest.setAmount(new BigDecimal("50.00"));
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        assertThrows(BadRequestException.class, () -> paymentService.processPayment(paymentRequest));
    }

    @Test
    void getPaymentByOrderId_Success() {
        Payment payment = Payment.builder().order(order).paymentStatus("PAID").build();
        when(paymentRepository.findByOrderOrderId(1)).thenReturn(Optional.of(payment));

        Payment result = paymentService.getPaymentByOrderId(1);

        assertNotNull(result);
        assertEquals("PAID", result.getPaymentStatus());
    }

    @Test
    void getPaymentByOrderId_NotFound() {
        when(paymentRepository.findByOrderOrderId(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> paymentService.getPaymentByOrderId(1));
    }
}
