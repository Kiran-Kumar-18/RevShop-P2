package com.rev.app.mapper;

import com.rev.app.dto.UserResponseDTO;
import com.rev.app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toDto(User entity) {
        if (entity == null) {
            return null;
        }

        return UserResponseDTO.builder()
                .userId(entity.getUserId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .role(entity.getRole())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

