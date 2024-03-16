package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.UserDao;
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
        HashMap<Integer, UserDao> usersDao = repository.getUsers();
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
    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    @Override
    public UserDto getUser(int id) {
        UserDao userDao = repository.getUser(id);

        return UserDto.builder()
                .name(userDao.getName())
                .id(userDao.getId())
                .walletId(userDao.getWalletId())
                .build();
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserDao userDao = repository.getUser(userDto.getId());
        userDao.setName(userDto.getName());
        userDao.setEmail(userDto.getEmail());
        userDao.setPassword(userDto.getPassword());

        repository.updateUser(userDao);
    }

    @Override
    public void registerUser(UserDto userDto) {
        UserDao userDao = new UserDao();
        userDao.setName(userDto.getName());
        userDao.setId(userDto.getId());
        userDao.setEmail(userDto.getEmail());
        userDao.setWalletId(userDto.getWalletId());
        userDao.setPassword(userDto.getPassword());

        repository.registerUser(userDao);
    }
}
