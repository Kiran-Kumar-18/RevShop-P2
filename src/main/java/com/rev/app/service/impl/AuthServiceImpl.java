package com.rev.app.service.impl;

import com.rev.app.config.JwtService;
import com.rev.app.dto.LoginRequestDTO;
import com.rev.app.dto.RegisterRequestDTO;
import com.rev.app.entity.User;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.IAuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements IAuthService {
    private final IUserRepository iuserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final com.rev.app.repository.ISellerRepository isellerRepository;

    @Override
    public void register(RegisterRequestDTO request) {
        if (iuserRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        // Ensure ROLE_ prefix
        String role = request.getRole().toUpperCase();
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        
        User user = new User(null, request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getPhone(), role, request.getSecurityQuestion(), request.getSecurityAnswer(), LocalDateTime.now(), null);
        user = iuserRepository.save(user);

        // If the user is a seller, create the corresponding seller entity
        if ("ROLE_SELLER".equals(role)) {
            com.rev.app.entity.Seller seller = new com.rev.app.entity.Seller();
            seller.setUser(user);
            seller.setBusinessName(request.getBusinessName() != null ? request.getBusinessName() : request.getName() + " Store");
            seller.setGstNumber(request.getGstNumber());
            seller.setAddress(request.getAddress());
            seller.setCreatedAt(LocalDateTime.now());
            isellerRepository.save(seller);
        }
    }

    @Override
    public String login(LoginRequestDTO request) {
        // Let Spring Security handle authentication
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        return jwtService.generateToken(request.getEmail());
    }

    @Override
    public String getSecurityQuestion(String email) {
        User user = iuserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No user found with this email"));
        if (user.getSecurityQuestion() == null || user.getSecurityQuestion().isEmpty()) {
            throw new RuntimeException("No security question set for this user");
        }
        return user.getSecurityQuestion();
    }

    @Override
    public void resetPassword(com.rev.app.dto.ResetPasswordRequestDTO request) {
        User user = iuserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getSecurityAnswer().equalsIgnoreCase(request.getSecurityAnswer())) {
            throw new RuntimeException("Invalid security answer");
        }

        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        iuserRepository.save(user);
    }

    @java.lang.SuppressWarnings("all")
    
    public AuthServiceImpl(final IUserRepository iuserRepository, final PasswordEncoder passwordEncoder, final JwtService jwtService, final AuthenticationManager authenticationManager, final com.rev.app.repository.ISellerRepository isellerRepository) {
        this.iuserRepository = iuserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.isellerRepository = isellerRepository;
    }
}
