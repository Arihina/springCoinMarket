package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.User;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.UserServiceMemory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
    private final UserService service;

    public UserController() {
        service = new UserServiceMemory();
    }

    @GetMapping("/users")
    public HashMap<Integer, User> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/registration")
    public void registerUser(@RequestBody User user) {
        service.registerUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

}
