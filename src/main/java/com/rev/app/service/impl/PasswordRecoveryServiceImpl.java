package com.rev.app.service.impl;

import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.entity.PasswordRecovery;
import com.rev.app.entity.User;
import com.rev.app.repository.IPasswordRecoveryRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.IPasswordRecoveryService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordRecoveryServiceImpl implements IPasswordRecoveryService {
    private final IPasswordRecoveryRepository ipasswordRecoveryRepository;
    private final IUserRepository iuserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void initiateRecovery(String email) {
        User user = iuserRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("No user found with email: " + email));
        String token = UUID.randomUUID().toString();
        PasswordRecovery recovery = PasswordRecovery.builder().user(user).token(token).expiresAt(LocalDateTime.now().plusHours(1)).isUsed(false).build();
        ipasswordRecoveryRepository.save(recovery);
        // In production: send token via email service
        System.out.println("[PASSWORD RECOVERY] Token for " + email + ": " + token);
    }

    @Override
    @Transactional
    public void resetPassword(String token, String newPassword) {
        PasswordRecovery recovery = ipasswordRecoveryRepository.findByToken(token).orElseThrow(() -> new ResourceNotFoundException("Invalid or unknown recovery token"));
        if (recovery.getIsUsed()) {
            throw new BadRequestException("Recovery token has already been used");
        }
        if (recovery.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Recovery token has expired");
        }
        if (newPassword == null || newPassword.length() < 6) {
            throw new BadRequestException("New password must be at least 6 characters");
        }
        User user = recovery.getUser();
        user.setPasswordHash(passwordEncoder.encode(newPassword));
        iuserRepository.save(user);
        recovery.setIsUsed(true);
        ipasswordRecoveryRepository.save(recovery);
    }

    @Override
    public String getSecurityQuestion(String email) {
        User user = iuserRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("No user found with email: " + email));
        if (user.getSecurityQuestion() == null || user.getSecurityQuestion().isEmpty()) {
            throw new BadRequestException("No security question set for this user");
        }
        return user.getSecurityQuestion();
    }

    @Override
    public void verifySecurityAnswer(String email, String securityAnswer) {
        User user = iuserRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("No user found with email: " + email));
        if (user.getSecurityAnswer() == null || !user.getSecurityAnswer().equalsIgnoreCase(securityAnswer.trim())) {
            throw new BadRequestException("Invalid security answer");
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public PasswordRecoveryServiceImpl(final IPasswordRecoveryRepository ipasswordRecoveryRepository, final IUserRepository iuserRepository, final PasswordEncoder passwordEncoder) {
        this.ipasswordRecoveryRepository = ipasswordRecoveryRepository;
        this.iuserRepository = iuserRepository;
        this.passwordEncoder = passwordEncoder;
    }
}
