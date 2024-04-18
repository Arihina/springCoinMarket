package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.service.RegistrationServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationServiceDb serviceDb;

    @Autowired
    public RegistrationController(RegistrationServiceDb serviceDb) {
        this.serviceDb = serviceDb;
    }

    @PostMapping("/login/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        serviceDb.save(userDto);
    }
}
