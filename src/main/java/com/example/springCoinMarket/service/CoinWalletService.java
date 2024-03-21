package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.CoinWalletDto;

import java.util.HashMap;

public interface CoinWalletService {
    HashMap<Integer, CoinWalletDto> getCoinWallets();

    CoinWalletDto getCoinWallet(Integer id);

    void addCoinWallet(CoinWalletDto coinWalletDto);

    void deleteCoinWallet(Integer id);

    void updateCoinWallet(CoinWalletDto coinWalletDto);
}
