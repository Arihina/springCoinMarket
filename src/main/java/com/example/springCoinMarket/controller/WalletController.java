package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.WalletDto;
import com.example.springCoinMarket.service.WalletService;
import com.example.springCoinMarket.service.WalletServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class WalletController {

    private final WalletService service;

    @Autowired
    public WalletController(WalletService service) {
        this.service = service;
    }

    @GetMapping("/wallet")
    public HashMap<Long, WalletDto> getWallets() {
        return service.getWallets();
    }

    @GetMapping("wallet/{id}")
    public WalletDto getWallet(@PathVariable Long id) {
        return service.getWallet(id);
    }


    @DeleteMapping("/wallet/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWallet(@PathVariable Long id) {
        service.deleteWallet(id);
    }
}
