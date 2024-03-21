package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @Autowired
    private WalletController walletController;
    private final BalanceService service;

    public BalanceController() {
        service = new BalanceService();
    }

    @PutMapping("/cash_in")
    public void cashIn(@RequestBody CoinDto coinDto, Integer walletId) {
        service.cashIn(coinDto, walletController.getWallet(walletId));
    }

    @PutMapping("/cash_out")
    public void cashOut(@RequestBody CoinDto coinDto, Integer walletId) {
        service.cashOut(coinDto, walletController.getWallet(walletId));
    }
}
