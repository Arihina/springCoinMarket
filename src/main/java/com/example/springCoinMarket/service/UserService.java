package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.UserDto;

import java.util.HashMap;

public interface UserService {

    HashMap<Long, UserDto> getUsers();
    void registerUser(UserDto userDto);
    void deleteUser(Long id);
    UserDto getUser(Long id);
    void updateUser(UserDto userDto);
}
