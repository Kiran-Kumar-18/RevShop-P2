package com.rev.app.service.impl;

import com.rev.app.entity.PasswordRecovery;
import com.rev.app.entity.User;
import com.rev.app.exception.BadRequestException;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IPasswordRecoveryRepository;
import com.rev.app.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordRecoveryServiceImplTest {

    @Mock
    private IPasswordRecoveryRepository passwordRecoveryRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private PasswordRecoveryServiceImpl passwordRecoveryService;

    private User user;
    private PasswordRecovery recovery;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        user.setSecurityQuestion("What?");
        user.setSecurityAnswer("This.");

        recovery = PasswordRecovery.builder()
                .user(user)
                .token("valid-token")
                .expiresAt(LocalDateTime.now().plusHours(1))
                .isUsed(false)
                .build();
    }

    @Test
    void initiateRecovery_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        
        passwordRecoveryService.initiateRecovery("test@example.com");

        verify(passwordRecoveryRepository, times(1)).save(any(PasswordRecovery.class));
    }

    @Test
    void resetPassword_Success() {
        when(passwordRecoveryRepository.findByToken("valid-token")).thenReturn(Optional.of(recovery));
        when(passwordEncoder.encode("new-password")).thenReturn("encoded-password");

        passwordRecoveryService.resetPassword("valid-token", "new-password");

        assertTrue(recovery.getIsUsed());
        assertEquals("encoded-password", user.getPasswordHash());
        verify(userRepository, times(1)).save(user);
        verify(passwordRecoveryRepository, times(1)).save(recovery);
    }

    @Test
    void resetPassword_ExpiredToken() {
        recovery.setExpiresAt(LocalDateTime.now().minusHours(1));
        when(passwordRecoveryRepository.findByToken("valid-token")).thenReturn(Optional.of(recovery));

        assertThrows(BadRequestException.class, () -> passwordRecoveryService.resetPassword("valid-token", "new-password"));
    }

    @Test
    void getSecurityQuestion_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        String result = passwordRecoveryService.getSecurityQuestion("test@example.com");
        assertEquals("What?", result);
    }

    @Test
    void verifySecurityAnswer_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        passwordRecoveryService.verifySecurityAnswer("test@example.com", "This.");
        // Should not throw exception
    }

    @Test
    void verifySecurityAnswer_Failure() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        assertThrows(BadRequestException.class, () -> passwordRecoveryService.verifySecurityAnswer("test@example.com", "Wrong"));
    }
}
