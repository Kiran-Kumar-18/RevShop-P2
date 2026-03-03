package com.rev.app.controller;

import com.rev.app.dto.UserResponseDTO;
import com.rev.app.mapper.UserMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final IUserService iuserService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable Integer id) {
        UserResponseDTO user = userMapper.toDto(iuserService.getUserById(id));
        return ResponseEntity.ok(ApiResponse.success(user, "User fetched successfully"));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserByEmail(@PathVariable String email) {
        UserResponseDTO user = userMapper.toDto(iuserService.getUserByEmail(email));
        return ResponseEntity.ok(ApiResponse.success(user, "User fetched successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public UserController(final IUserService iuserService, final UserMapper userMapper) {
        this.iuserService = iuserService;
        this.userMapper = userMapper;
    }
}
