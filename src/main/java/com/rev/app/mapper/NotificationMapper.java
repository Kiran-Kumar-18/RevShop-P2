package com.rev.app.mapper;

import com.rev.app.dto.NotificationResponseDTO;
import com.rev.app.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationResponseDTO toDto(Notification entity) {
        if (entity == null) {
            return null;
        }

        return NotificationResponseDTO.builder()
                .notificationId(entity.getNotificationId())
                .userId(entity.getUser() != null ? entity.getUser().getUserId() : null)
                .title(entity.getTitle())
                .message(entity.getMessage())
                .type(entity.getType())
                .isRead(entity.getIsRead())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

