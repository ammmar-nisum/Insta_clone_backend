package com.instagram.clone.service;

import com.instagram.clone.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void deleteUserById(Long id);
}
