package com.rev.app.repository;

import com.rev.app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByOrderOrderId(Integer orderId);
}


