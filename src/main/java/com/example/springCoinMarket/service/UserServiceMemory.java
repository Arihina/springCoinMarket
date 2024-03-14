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
    public HashMap<Integer, String> getUsers() {
        HashMap<Integer, UserDao> usersDao = repository.getUsers();
        HashMap<Integer, String> usersInfo = new HashMap<>();

        for (Integer key: usersDao.keySet())
        {
            String info = String.format(
                    """
                    name: %s
                    id: %d
                    wallet id: %d
                    """,
                    usersDao.get(key).getName(), usersDao.get(key).getId(), usersDao.get(key).getWalletId());

            usersInfo.put(key, info);
        }

        return usersInfo;
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    @Override
    public String getUser(int id) {
        UserDao userDao = repository.getUser(id);
        UserDto userDto = UserDto.builder()
                .name(userDao.getName())
                .id(userDao.getId())
                .walletId(userDao.getWalletId())
                .build();

        return String.format("""
                name: %s
                id: %d
                wallet id: %d
                """, userDto.getName(), userDto.getId(), userDto.getWalletId());
    }

    @Override
    public void updateUser(UserDao userDao) {
        repository.updateUser(userDao);
    }

    @Override
    public void registerUser(UserDao newUserDao) {
        repository.registerUser(newUserDao);
    }
}
