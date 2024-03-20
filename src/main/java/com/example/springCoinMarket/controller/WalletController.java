package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.WalletDto;
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
    public HashMap<Integer, WalletDto> getWallets()
    {
        return service.getWallets();
    }

    @GetMapping("wallet/{id}")
    public WalletDto getWallet(@PathVariable Integer id) {
        return  service.getWallet(id);
    }

    @PostMapping("/wallet/create")
    public void createWallet(@RequestBody WalletDto walletDto) {
        service.createWallet(walletDto);
    }

    @DeleteMapping("/wallet/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWallet(@PathVariable Integer id) {
        service.deleteWallet(id);
    }
}
