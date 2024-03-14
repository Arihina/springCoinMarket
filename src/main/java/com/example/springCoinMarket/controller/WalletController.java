package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.service.WalletService;
import com.example.springCoinMarket.service.WalletServiceMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class WalletController {
    private final WalletService service;

    public WalletController()
    {
        service = new WalletServiceMemory();
    }

    @GetMapping("/wallet")
    public HashMap<Integer, String> getWallets()
    {
        return service.getWallets();
    }

    @GetMapping("wallet/{id}")
    public String getWallet(@PathVariable int id) {
        return  service.getWallet(id);
    }
}
