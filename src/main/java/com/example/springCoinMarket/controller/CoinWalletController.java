package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.dto.CoinWalletDto;
import com.example.springCoinMarket.service.CoinServiceMemory;
import com.example.springCoinMarket.service.CoinWalletService;
import com.example.springCoinMarket.service.CoinWalletServiceMemory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoinWalletController {
    private final CoinWalletService service;
    private final CoinServiceMemory coinService;

    public CoinWalletController() {
        service = new CoinWalletServiceMemory();
        coinService = new CoinServiceMemory();
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

    @PostMapping("/coin_wallet/registration")
    public void addCoinWallet(@RequestBody CoinWalletDto coinWalletDto) {
        service.addCoinWallet(coinWalletDto);
    }

    /*
    @PostMapping("/debug/coin")
    public void addCoin(@RequestBody CoinDto coinDto) {
        coinService.addCoin(coinDto);
    }
     */
}
