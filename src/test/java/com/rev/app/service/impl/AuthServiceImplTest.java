package com.rev.app.service.impl;

import com.rev.app.config.JwtService;
import com.rev.app.dto.LoginRequestDTO;
import com.rev.app.dto.RegisterRequestDTO;
import com.rev.app.dto.ResetPasswordRequestDTO;
import com.rev.app.entity.Seller;
import com.rev.app.entity.User;
import com.rev.app.repository.ISellerRepository;
import com.rev.app.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

    @Mock
    private IUserRepository userRepository;
    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthServiceImpl authService;

    private RegisterRequestDTO registerRequest;
    private User user;

    @BeforeEach
    void setUp() {
        registerRequest = RegisterRequestDTO.builder()
                .name("Test User")
                .email("test@example.com")
                .password("password")
                .role("BUYER")
                .securityQuestion("What is your pet's name?")
                .securityAnswer("Buddy")
                .build();

        user = new User();
        user.setUserId(1);
        user.setEmail("test@example.com");
        user.setPasswordHash("encodedPassword");
        user.setSecurityQuestion("What is your pet's name?");
        user.setSecurityAnswer("Buddy");
    }

    @Test
    void register_BuyerSuccess() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        authService.register(registerRequest);

        verify(userRepository, times(1)).save(any(User.class));
        verify(sellerRepository, never()).save(any(Seller.class));
    }

    @Test
    void register_SellerSuccess() {
        registerRequest.setRole("SELLER");
        registerRequest.setBusinessName("Test Store");
        
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        authService.register(registerRequest);

        verify(userRepository, times(1)).save(any(User.class));
        verify(sellerRepository, times(1)).save(any(Seller.class));
    }

    @Test
    void register_EmailExists() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> authService.register(registerRequest));
    }

    @Test
    void login_Success() {
        LoginRequestDTO loginRequest = LoginRequestDTO.builder()
                .email("test@example.com")
                .password("password")
                .build();

        when(jwtService.generateToken("test@example.com")).thenReturn("mock-token");

        String token = authService.login(loginRequest);

        assertEquals("mock-token", token);
        verify(authenticationManager, times(1)).authenticate(any());
    }

    @Test
    void getSecurityQuestion_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        String question = authService.getSecurityQuestion("test@example.com");

        assertEquals("What is your pet's name?", question);
    }

    @Test
    void resetPassword_Success() {
        ResetPasswordRequestDTO resetRequest = new ResetPasswordRequestDTO(
                "test@example.com", "Buddy", "newPassword", "newPassword"
        );

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.encode("newPassword")).thenReturn("newEncodedPassword");

        authService.resetPassword(resetRequest);

        assertEquals("newEncodedPassword", user.getPasswordHash());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void resetPassword_InvalidAnswer() {
        ResetPasswordRequestDTO resetRequest = new ResetPasswordRequestDTO(
                "test@example.com", "WrongAnswer", "newPassword", "newPassword"
        );

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> authService.resetPassword(resetRequest));
    }

    @Test
    void resetPassword_Mismatch() {
        ResetPasswordRequestDTO resetRequest = new ResetPasswordRequestDTO(
                "test@example.com", "Buddy", "newPassword", "differentPassword"
        );

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> authService.resetPassword(resetRequest));
    }
}
