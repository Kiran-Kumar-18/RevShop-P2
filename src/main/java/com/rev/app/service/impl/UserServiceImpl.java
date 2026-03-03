package com.rev.app.service.impl;

import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.IUserService;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final IUserRepository iuserRepository;

    @Override
    public User getUserById(Integer id) {
        logger.debug("Fetching user by ID: {}", id);
        return iuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User getUserByEmail(String email) {
        logger.debug("Fetching user by email: {}", email);
        return iuserRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    @java.lang.SuppressWarnings("all")
    
    public UserServiceImpl(final IUserRepository iuserRepository) {
        this.iuserRepository = iuserRepository;
    }
}
