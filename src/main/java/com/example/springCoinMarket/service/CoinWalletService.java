package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.CoinWalletDto;

import java.util.HashMap;

public interface CoinWalletService {
    HashMap<Long, CoinWalletDto> getCoinWallets();

    CoinWalletDto getCoinWallet(Long id);

    void addCoinWallet(CoinWalletDto coinWalletDto);

    void deleteCoinWallet(Long id);

    void updateCoinWallet(CoinWalletDto coinWalletDto);
}
