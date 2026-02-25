package com.rev.app.repository;

import com.rev.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserUserId(Integer userId);
    Page<Order> findByUserUserId(Integer userId, Pageable pageable);
    List<Order> findByStatus(String status);
    
    @org.springframework.data.jpa.repository.Query("SELECT DISTINCT o FROM Order o JOIN OrderItem oi ON o.orderId = oi.order.orderId WHERE oi.seller.user.userId = :sellerUserId")
    Page<Order> findOrdersBySellerUserId(@org.springframework.data.repository.query.Param("sellerUserId") Integer sellerUserId, Pageable pageable);
 }


