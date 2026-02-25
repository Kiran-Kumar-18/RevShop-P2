package com.rev.app.repository;

import com.rev.app.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserUserId(Integer userId);
    List<Notification> findByUserUserIdAndIsReadFalse(Integer userId);
}


