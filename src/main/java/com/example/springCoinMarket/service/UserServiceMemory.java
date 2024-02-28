package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.User;
import com.example.springCoinMarket.dao.repository.UserMemoryRepository;

import java.util.HashMap;

public class UserServiceMemory implements UserService {
    private final UserMemoryRepository repository;

    public UserServiceMemory() {
        repository = new UserMemoryRepository();
    }

    @Override
    public HashMap<Integer, User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return repository.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        repository.updateUser(user);
    }

    @Override
    public void registerUser(User newUser) {
        repository.registerUser(newUser);
    }
}
