package com.example.courseWork.service;

import com.example.courseWork.models.User;

public interface UserService {
    public void addUser(User user);
    public User findByUsername(String username);
}
