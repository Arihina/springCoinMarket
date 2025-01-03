package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.UserConverter;
import com.example.springCoinMarket.dao.model.User;
import com.example.springCoinMarket.dao.repository.UserMemoryRepository;
import com.example.springCoinMarket.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceMemory implements UserService {
    private final UserMemoryRepository repository;

    public UserServiceMemory() {
        repository = new UserMemoryRepository();
    }

    @Override
    public HashMap<Long, UserDto> getUsers() {
        Map<Long, User> usersDao = repository.getUsers();
        HashMap<Long, UserDto> usersDto = new HashMap<>();

        for (Long key : usersDao.keySet()) {
            var modelDto = UserConverter.toFullDto(usersDao.get(key));
            usersDto.put(key, modelDto);
        }

        return usersDto;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }

    @Override
    public UserDto getUser(Long id) {
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
        repository.registerUser(UserConverter.toModel(userDto));
    }
}
