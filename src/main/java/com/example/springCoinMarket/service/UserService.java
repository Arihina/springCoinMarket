package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.UserDto;

import java.util.HashMap;

public interface UserService {

    HashMap<Integer, UserDto> getUsers();
    void registerUser(UserDto userDto);
    void deleteUser(Integer id);
    UserDto getUser(Integer id);
    void updateUser(UserDto userDto);
}
