package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.dto.WalletDto;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.UserServiceMemory;
import com.example.springCoinMarket.service.WalletService;
import com.example.springCoinMarket.service.WalletServiceMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
