package com.rev.app.service;

public interface IPasswordRecoveryService {
    void initiateRecovery(String email);
    void resetPassword(String token, String newPassword);
    String getSecurityQuestion(String email);
    void verifySecurityAnswer(String email, String securityAnswer);
}


