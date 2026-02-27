package com.rev.app.controller;

import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IPasswordRecoveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/recovery", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class PasswordRecoveryController {
    private final IPasswordRecoveryService ipasswordRecoveryService;

    @PostMapping("/initiate")
    public ResponseEntity<ApiResponse<Void>> initiateRecovery(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        ipasswordRecoveryService.initiateRecovery(email);
        return ResponseEntity.ok(ApiResponse.success(null, "Recovery token generated (check logs/email)"));
    }

    @PostMapping("/reset")
    public ResponseEntity<ApiResponse<Void>> resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String newPassword = request.get("newPassword");
        ipasswordRecoveryService.resetPassword(token, newPassword);
        return ResponseEntity.ok(ApiResponse.success(null, "Password reset successfully"));
    }

    @GetMapping("/question")
    public ResponseEntity<ApiResponse<String>> getSecurityQuestion(@RequestParam String email) {
        String question = ipasswordRecoveryService.getSecurityQuestion(email);
        return ResponseEntity.ok(ApiResponse.success(question, "Security question retrieved"));
    }

    @PostMapping("/verify-answer")
    public ResponseEntity<ApiResponse<Void>> verifySecurityAnswer(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String answer = request.get("answer");
        ipasswordRecoveryService.verifySecurityAnswer(email, answer);
        return ResponseEntity.ok(ApiResponse.success(null, "Security answer verified successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public PasswordRecoveryController(final IPasswordRecoveryService ipasswordRecoveryService) {
        this.ipasswordRecoveryService = ipasswordRecoveryService;
    }
}
