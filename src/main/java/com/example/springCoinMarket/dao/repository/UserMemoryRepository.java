package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserMemoryRepository {
    private final Map<Integer, User> users = new HashMap<>();

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void deleteUser(Integer id) {
        if (users.get(id) != null) {
            users.remove(id);
        }
    }

    public User getUser(Integer id) {
        if (users.get(id) != null) {
            return users.get(id);
        }
        return null;
    }

    public void updateUser(User user) {
        if (users.get(user.getId()) != null) {
            users.put(user.getId(), user);
        }
    }

    public void registerUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }
}
