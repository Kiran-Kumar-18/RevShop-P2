package com.rev.app.controller;

import com.rev.app.dto.LoginRequestDTO;
import com.rev.app.dto.RegisterRequestDTO;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LogManager.getLogger(AuthController.class);
    private final IAuthService iauthService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@Valid @RequestBody RegisterRequestDTO request) {
        logger.info("Registering user: {}", request.getEmail());
        iauthService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(null, "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginRequestDTO request) {
        logger.info("Login attempt for user: {}", request.getEmail());
        String token = iauthService.login(request);
        return ResponseEntity.ok(ApiResponse.success(token, "Login successful"));
    }

    @GetMapping("/security-question")
    public ResponseEntity<ApiResponse<String>> getSecurityQuestion(@RequestParam String email) {
        String question = iauthService.getSecurityQuestion(email);
        return ResponseEntity.ok(ApiResponse.success(question, "Security question fetched"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<Void>> resetPassword(@Valid @RequestBody com.rev.app.dto.ResetPasswordRequestDTO request) {
        iauthService.resetPassword(request);
        return ResponseEntity.ok(ApiResponse.success(null, "Password reset successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public AuthController(final IAuthService iauthService) {
        this.iauthService = iauthService;
    }
}
