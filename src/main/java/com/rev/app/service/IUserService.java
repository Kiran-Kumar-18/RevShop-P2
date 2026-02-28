package com.rev.app.service;

import com.rev.app.entity.User;

public interface IUserService {
    User getUserById(Integer id);
    User getUserByEmail(String email);
    // You can add more user-related business logic here (e.g., update profile, change password)
}


