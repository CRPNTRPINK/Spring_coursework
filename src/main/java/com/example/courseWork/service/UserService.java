package com.example.courseWork.service;

import com.example.courseWork.models.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User findByUsername(String username);
    public List<User> getAllUsers();
    public void deleteUser(Long id);
    public void saveFoundUser(User user);
}
