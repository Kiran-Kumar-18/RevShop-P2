package com.rev.app.repository;

import com.rev.app.entity.PasswordRecovery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPasswordRecoveryRepository extends JpaRepository<PasswordRecovery, Integer> {
    Optional<PasswordRecovery> findByUserUserId(Integer userId);
    Optional<PasswordRecovery> findByToken(String token);
}


