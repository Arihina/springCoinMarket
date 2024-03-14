package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.UserDao;
import com.example.springCoinMarket.dto.UserDto;

import java.util.HashMap;

public interface UserService {

    HashMap<Integer, String> getUsers();
    void registerUser(UserDao userDao);
    void deleteUser(int id);
    String getUser(int id);
    void updateUser(UserDao userDao);
}
