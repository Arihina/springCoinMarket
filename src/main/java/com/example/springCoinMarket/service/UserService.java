package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.User;

import java.util.HashMap;

public interface UserService {

    HashMap<Integer, User> getUsers();
    void registerUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    void updateUser(User user);
}
