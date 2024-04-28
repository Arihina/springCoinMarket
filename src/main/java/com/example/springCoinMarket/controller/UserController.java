package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public HashMap<Long, UserDto> getUsers() {
        return service.getUsers();
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        service.updateUser(userDto);
    }

}
