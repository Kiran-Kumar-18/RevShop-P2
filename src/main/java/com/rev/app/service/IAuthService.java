package com.rev.app.service;

import com.rev.app.dto.LoginRequestDTO;
import com.rev.app.dto.RegisterRequestDTO;

public interface IAuthService {
    void register(RegisterRequestDTO request);
    String login(LoginRequestDTO request);
    String getSecurityQuestion(String email);
    void resetPassword(com.rev.app.dto.ResetPasswordRequestDTO request);
}


