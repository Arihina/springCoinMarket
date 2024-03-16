package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.UserDao;
import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.dto.WalletDto;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.UserServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
    private final UserService service;
    @Autowired
    private WalletController walletController;

    public UserController() {
        service = new UserServiceMemory();
    }

    @GetMapping("/user")
    public HashMap<Integer, UserDto> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        service.registerUser(userDto);
        walletController.createWallet(WalletDto.builder().
                userId(userDto.getId()).walletId(userDto.getWalletId()).coinsId(null).build());
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        walletController.deleteWallet(getUser(id).getWalletId());
        service.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        service.updateUser(userDto);
    }

}
