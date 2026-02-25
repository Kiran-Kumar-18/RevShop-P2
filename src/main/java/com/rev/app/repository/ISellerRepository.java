package com.rev.app.repository;

import com.rev.app.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Integer> {
    Optional<Seller> findByUserUserId(Integer userId);
}


