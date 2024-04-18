package com.example.springCoinMarket.service;


import com.example.springCoinMarket.converter.UserConverter;
import com.example.springCoinMarket.dao.repository.UserRepository;
import com.example.springCoinMarket.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class UserServiceDb implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
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
    @Transactional
    public void registerUser(UserDto userDto) {
        var user = UserConverter.toModel(userDto);
        repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        return UserConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        repository.save(UserConverter.toModel(userDto));
    }
}
