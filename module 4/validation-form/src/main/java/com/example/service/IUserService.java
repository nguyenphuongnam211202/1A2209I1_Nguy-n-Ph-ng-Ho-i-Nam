package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface IUserService {
    boolean create(User user);
    boolean update(User user);
    boolean deleteById(int id);
    User findById(int id);
    List<User> findAll();
}
