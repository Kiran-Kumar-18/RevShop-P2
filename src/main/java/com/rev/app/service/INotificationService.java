package com.rev.app.service;

import com.rev.app.entity.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> getUserNotifications(Integer userId);
    void markAsRead(Integer notificationId);
    void createNotification(com.rev.app.entity.User user, String title, String message, String type);
}


