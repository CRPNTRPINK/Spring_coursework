package com.example.courseWork.dao;

import com.example.courseWork.models.User;

public interface UserDAO {

    public void save(User user);
    public User findByUsername(String username);
}
