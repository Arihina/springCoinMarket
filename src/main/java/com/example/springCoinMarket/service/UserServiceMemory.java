package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.UserConverter;
import com.example.springCoinMarket.dao.model.User;
import com.example.springCoinMarket.dao.repository.UserMemoryRepository;
import com.example.springCoinMarket.dto.UserDto;

import java.util.HashMap;

public class UserServiceMemory implements UserService {
    private final UserMemoryRepository repository;

    public UserServiceMemory() {
        repository = new UserMemoryRepository();
    }

    @Override
    public HashMap<Integer, UserDto> getUsers() {
        HashMap<Integer, User> usersDao = repository.getUsers();
        HashMap<Integer, UserDto> usersDto = new HashMap<>();

        for (Integer key : usersDao.keySet()) {
            var modelDto = UserConverter.toFullDto(usersDao.get(key));
            usersDto.put(key, modelDto);
        }

        return usersDto;
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteUser(id);
    }

    @Override
    public UserDto getUser(Integer id) {
        User user = repository.getUser(id);

        return UserConverter.toDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = repository.getUser(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        repository.updateUser(user);
    }

    @Override
    public void registerUser(UserDto userDto) {
        User user = UserConverter.toModel(userDto);

        repository.registerUser(user);
    }
}
