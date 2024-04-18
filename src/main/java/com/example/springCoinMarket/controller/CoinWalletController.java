package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinWalletDto;
import com.example.springCoinMarket.service.CoinWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoinWalletController {
    private final CoinWalletService service;

    @Autowired
    public CoinWalletController(CoinWalletService service) {
        this.service = service;
    }

    @GetMapping("/coin_wallet")
    public HashMap<Long, CoinWalletDto> getCoinWallets() {
        return service.getCoinWallets();
    }

    @GetMapping("/coin_wallet/{id}")
    public CoinWalletDto getCoinWallet(@PathVariable Long id) {
        return service.getCoinWallet(id);
    }

    @PutMapping("/coin_wallet/{id}")
    public void updateCoinWallet(@RequestBody CoinWalletDto coinWalletDto, @PathVariable Integer id) {
        service.updateCoinWallet(coinWalletDto);
    }

    @DeleteMapping("/coin_wallet/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoinWallet(@PathVariable Long id) {
        service.deleteCoinWallet(id);
    }

    @PostMapping("/coin_wallet/{walletId}/registration")
    public void addCoinWallet(@RequestBody CoinWalletDto coinWalletDto, @PathVariable Long walletId) {
        service.addCoinWallet(coinWalletDto, walletId);
    }
}
