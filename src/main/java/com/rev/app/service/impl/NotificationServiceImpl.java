package com.rev.app.service.impl;

import com.rev.app.entity.Notification;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.INotificationRepository;
import com.rev.app.service.INotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService {
    private static final Logger logger = LogManager.getLogger(NotificationServiceImpl.class);
    private final INotificationRepository inotificationRepository;

    @Override
    public List<Notification> getUserNotifications(Integer userId) {
        return inotificationRepository.findByUserUserId(userId);
    }

    @Override
    @Transactional
    public void markAsRead(Integer notificationId) {
        Notification notification = inotificationRepository.findById(notificationId).orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + notificationId));
        notification.setIsRead(true);
        inotificationRepository.save(notification);
        logger.debug("Notification marked as read: ID {}", notificationId);
    }

    @Override
    @Transactional
    public void createNotification(com.rev.app.entity.User user, String title, String message, String type) {
        Notification notification = Notification.builder().user(user).title(title).message(message).type(type).isRead(false).build();
        inotificationRepository.save(notification);
        logger.info("Notification created for User ID: {}, Type: {}, Title: {}", user.getUserId(), type, title);
    }

    @java.lang.SuppressWarnings("all")
    
    public NotificationServiceImpl(final INotificationRepository inotificationRepository) {
        this.inotificationRepository = inotificationRepository;
    }
}
