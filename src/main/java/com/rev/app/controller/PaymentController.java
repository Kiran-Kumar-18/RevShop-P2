package com.rev.app.controller;

import com.rev.app.dto.PaymentRequestDTO;
import com.rev.app.dto.PaymentResponseDTO;
import com.rev.app.mapper.PaymentMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final IPaymentService ipaymentService;
    private final PaymentMapper paymentMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<PaymentResponseDTO>> processPayment(@Valid @RequestBody PaymentRequestDTO request) {
        System.out.println("Processing Payment Request: " + request);
        PaymentResponseDTO payment = paymentMapper.toDto(ipaymentService.processPayment(request));
        return ResponseEntity.ok(ApiResponse.success(payment, "Payment processed successfully"));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse<PaymentResponseDTO>> getPaymentByOrderId(@PathVariable Integer orderId) {
        PaymentResponseDTO payment = paymentMapper.toDto(ipaymentService.getPaymentByOrderId(orderId));
        return ResponseEntity.ok(ApiResponse.success(payment, "Payment fetched successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public PaymentController(final IPaymentService ipaymentService, final PaymentMapper paymentMapper) {
        this.ipaymentService = ipaymentService;
        this.paymentMapper = paymentMapper;
    }
}
