package com.rev.app.repository;

import com.rev.app.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderOrderId(Integer orderId);
    List<OrderItem> findBySellerSellerId(Integer sellerId);

    @org.springframework.data.jpa.repository.Query("SELECT SUM(oi.quantity) FROM OrderItem oi WHERE oi.product.productId = :productId AND (oi.order.status NOT IN ('CANCELLED', 'REJECTED'))") 
    Integer countSoldCountByProductId(Integer productId);
}


