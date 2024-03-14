package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.UserDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserMemoryRepository {
    private final HashMap<Integer, UserDao> users = new HashMap<>();


    public HashMap<Integer, UserDao> getUsers() {
        return users;
    }

    public void deleteUser(int id) {
        if (users.get(id) != null) {
            users.remove(id);
        }
    }

    public UserDao getUser(int id) {
        if (users.get(id) != null) {
            return users.get(id);
        }
        return null;
    }

    public void updateUser(UserDao userDao) {
        if (users.get(userDao.getId()) != null) {
            users.put(userDao.getId(), userDao);
        }
    }

    public void registerUser(UserDao newUserDao) {
        users.put(newUserDao.getId(), newUserDao);
    }
}
