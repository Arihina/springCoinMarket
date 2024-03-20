package com.example.springCoinMarket.service;

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
            UserDto modelDto = UserDto.builder().
                    name(usersDao.get(key).getName()).
                    email(usersDao.get(key).getEmail()).
                    password(usersDao.get(key).getPassword()).
                    id(usersDao.get(key).getId()).
                    walletId(usersDao.get(key).getWalletId()).
                    build();

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

        return UserDto.builder()
                .name(user.getName())
                .id(user.getId())
                .walletId(user.getWalletId())
                .build();
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
        User user = new User();
        user.setName(userDto.getName());
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setWalletId(userDto.getWalletId());
        user.setPassword(userDto.getPassword());

        repository.registerUser(user);
    }
}
