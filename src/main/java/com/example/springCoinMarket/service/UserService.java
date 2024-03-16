package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.UserDao;
import com.example.springCoinMarket.dto.UserDto;

import java.util.HashMap;

public interface UserService {

    HashMap<Integer, UserDto> getUsers();
    void registerUser(UserDto userDto);
    void deleteUser(int id);
    UserDto getUser(int id);
    void updateUser(UserDto userDto);
}
