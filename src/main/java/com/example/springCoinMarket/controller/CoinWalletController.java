package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinWalletDto;
import com.example.springCoinMarket.service.CoinWalletService;
import com.example.springCoinMarket.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoinWalletController {
    private final CoinWalletService service;
    private final WalletService walletService;

    @Autowired
    public CoinWalletController(CoinWalletService service, WalletService walletService) {
        this.service = service;
        this.walletService = walletService;
    }

    @GetMapping("/coin_wallet")
    public HashMap<Integer, CoinWalletDto> getCoinWallets() {
        return service.getCoinWallets();
    }

    @GetMapping("/coin_wallet/{id}")
    public CoinWalletDto getCoinWallet(@PathVariable Integer id) {
        return service.getCoinWallet(id);
    }

    @PutMapping("/coin_wallet/{id}")
    public void updateCoinWallet(@RequestBody CoinWalletDto coinWalletDto, @PathVariable Integer id) {
        service.updateCoinWallet(coinWalletDto);
    }

    @DeleteMapping("/coin_wallet/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoinWallet(@PathVariable Integer id) {
        service.deleteCoinWallet(id);
    }

    @PostMapping("/coin_wallet/{walletId}/registration")
    public void addCoinWallet(@RequestBody CoinWalletDto coinWalletDto, @PathVariable Integer walletId) {
        service.addCoinWallet(coinWalletDto);
        walletService.addCoinWallet(coinWalletDto.getId(), walletId);
    }
}
