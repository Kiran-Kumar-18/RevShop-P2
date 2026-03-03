package com.rev.app.controller;

import com.rev.app.dto.NotificationResponseDTO;
import com.rev.app.mapper.NotificationMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.INotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private static final Logger logger = LogManager.getLogger(NotificationController.class);
    private final INotificationService inotificationService;
    private final NotificationMapper notificationMapper;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<NotificationResponseDTO>>> getUserNotifications(@PathVariable Integer userId) {
        List<NotificationResponseDTO> notifications = inotificationService.getUserNotifications(userId).stream().map(notificationMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse.success(notifications, "User notifications fetched successfully"));
    }

    @PutMapping("/{notificationId}/read")
    public ResponseEntity<ApiResponse<Void>> markAsRead(@PathVariable Integer notificationId) {
        inotificationService.markAsRead(notificationId);
        return ResponseEntity.ok(ApiResponse.success(null, "Notification marked as read successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public NotificationController(final INotificationService inotificationService, final NotificationMapper notificationMapper) {
        this.inotificationService = inotificationService;
        this.notificationMapper = notificationMapper;
    }
}
