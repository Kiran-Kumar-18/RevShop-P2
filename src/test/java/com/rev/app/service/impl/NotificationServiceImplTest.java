package com.rev.app.service.impl;

import com.rev.app.entity.Notification;
import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.INotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceImplTest {

    @Mock
    private INotificationRepository notificationRepository;

    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Test
    void getUserNotifications_Success() {
        when(notificationRepository.findByUserUserId(1)).thenReturn(List.of(new Notification()));
        
        List<Notification> result = notificationService.getUserNotifications(1);
        
        assertFalse(result.isEmpty());
    }

    @Test
    void markAsRead_Success() {
        Notification notification = new Notification();
        notification.setNotificationId(1);
        notification.setIsRead(false);

        when(notificationRepository.findById(1)).thenReturn(Optional.of(notification));

        notificationService.markAsRead(1);

        assertTrue(notification.getIsRead());
        verify(notificationRepository, times(1)).save(notification);
    }

    @Test
    void markAsRead_NotFound() {
        when(notificationRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> notificationService.markAsRead(99));
    }

    @Test
    void createNotification_Success() {
        User user = new User();
        user.setUserId(1);

        notificationService.createNotification(user, "Title", "Message", "TYPE");

        verify(notificationRepository, times(1)).save(any(Notification.class));
    }
}
