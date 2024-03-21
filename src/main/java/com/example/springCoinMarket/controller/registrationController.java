package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.dto.WalletDto;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.UserServiceMemory;
import com.example.springCoinMarket.service.WalletService;
import com.example.springCoinMarket.service.WalletServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class registrationController {

    private final UserService userService;
    private final WalletService walletService;


    public registrationController() {
        userService = new UserServiceMemory();
        walletService = new WalletServiceMemory();
    }

    @PostMapping("/login/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        walletService.createWallet(WalletDto.builder().
                userId(userDto.getId()).id(userDto.getWalletId()).coinsIds(null).build());
    }

    @GetMapping("/debug/wallet")
    public HashMap<Integer, WalletDto> a() {
        return walletService.getWallets();
    }

    @GetMapping("/debug/user")
    public HashMap<Integer, UserDto> b() {
        return userService.getUsers();
    }
}
