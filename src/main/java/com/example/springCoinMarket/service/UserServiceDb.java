package com.example.springCoinMarket.service;


import com.example.springCoinMarket.converter.UserConverter;
import com.example.springCoinMarket.dao.repository.UserRepository;
import com.example.springCoinMarket.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class UserServiceDb implements UserService {
    private final UserRepository repository;

    @Override
    public HashMap<Long, UserDto> getUsers() {
        var users = repository.findAll();
        HashMap<Long, UserDto> usersDto = new HashMap<>();

        for (var user : users) {
            var modelDto = UserConverter.toDto(user);
            usersDto.put(modelDto.getId(), modelDto);
        }

        return usersDto;
    }

    @Override
    public void registerUser(UserDto userDto) {
        var user = UserConverter.toModel(userDto);
        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getUser(Long id) {
        return UserConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    public void updateUser(UserDto userDto) {
        repository.save(UserConverter.toModel(userDto));
    }
}
