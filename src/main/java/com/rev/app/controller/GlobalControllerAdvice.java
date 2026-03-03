package com.rev.app.controller;

import com.rev.app.config.JwtService;
import com.rev.app.repository.IUserRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ControllerAdvice
public class GlobalControllerAdvice {
    private static final Logger logger = LogManager.getLogger(GlobalControllerAdvice.class);

    private final JwtService jwtService;
    private final IUserRepository userRepository;

    public GlobalControllerAdvice(JwtService jwtService, IUserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("jwtToken")
    public String addJwtToken(Principal principal) {
        if (principal != null) {
            return jwtService.generateToken(principal.getName());
        }
        return null;
    }

    @ModelAttribute("userJson")
    public String addUserJson(Principal principal) {
        if (principal != null) {
            return userRepository.findByEmail(principal.getName()).map(user -> {
                String role = user.getRole().toUpperCase();
                if (!role.startsWith("ROLE_")) {
                    role = "ROLE_" + role;
                }
                return String.format("{\"userId\":%d,\"name\":\"%s\",\"email\":\"%s\",\"role\":\"%s\"}", 
                    user.getUserId(), user.getName(), user.getEmail(), role);
            }).orElse(null);
        }
        return null;
    }
}
