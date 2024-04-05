package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.dto.WalletDto;
import com.example.springCoinMarket.service.UserService;
import com.example.springCoinMarket.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final UserService userService;
    private final WalletService walletService;

    @Autowired
    public RegistrationController(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @PostMapping("/login/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        walletService.createWallet(WalletDto.builder().
                userId(userDto.getId()).id(userDto.getWalletId()).coinWalletIds(null).build());
    }
}
