package com.rev.app.service;

import com.rev.app.dto.OrderRequestDTO;
import com.rev.app.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Order placeOrder(OrderRequestDTO request);
    Order getOrderById(Integer id);
    Page<Order> getUserOrders(Integer userId, Pageable pageable);
    Page<Order> getSellerOrders(Integer sellerUserId, Pageable pageable);
    Order updateOrderStatus(Integer orderId, String status, Integer userId);
    java.util.List<com.rev.app.entity.OrderStatusHistory> getOrderHistory(Integer orderId);
    java.util.List<String> getOrderStatuses();
    java.util.List<com.rev.app.entity.OrderItem> getOrderItems(Integer orderId);
}


