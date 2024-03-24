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
    private final WalletService walletService;

    @Autowired
    public UserController(UserService service, WalletService walletService) {
        this.service = service;
        this.walletService = walletService;
    }

    @GetMapping("/user")
    public HashMap<Integer, UserDto> getUsers() {
        return service.getUsers();
    }


    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        walletService.deleteWallet(getUser(id).getWalletId());
        service.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        service.updateUser(userDto);
    }

}
