package com.example.springCoinMarket.repository;

import com.example.springCoinMarket.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserMemoryRepository {
    private final HashMap<Integer, User> users = new HashMap<>();


    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void deleteUser(int id) {
        if (users.get(id) != null) {
            users.remove(id);
        }
    }

    public User getUser(int id) {
        if (users.get(id) != null) {
            return users.get(id);
        }
        return null;
    }

    public void updateUser(User user) {
        if (users.get(user.getUserID()) != null) {
            users.put(user.getUserID(), user);
        }
    }

    public void registerUser(User newUser) {
        users.put(newUser.getUserID(), newUser);
    }
}
