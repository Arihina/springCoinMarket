package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.WalletDao;
import com.example.springCoinMarket.service.WalletService;
import com.example.springCoinMarket.service.WalletServiceMemory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/wallet/create")
    public void createWallet(@RequestBody WalletDao walletDao) {
        service.createWallet(walletDao);
    }

    @DeleteMapping("/wallet/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWallet(@PathVariable int id) {
        service.deleteWallet(id);
    }
}
