package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.WalletDto;

import java.util.HashMap;

public interface WalletService {

    HashMap<Integer, WalletDto> getWallets();
    WalletDto getWallet(Integer id);

    void createWallet(WalletDto WalletDao);

    void deleteWallet(Integer id);
}
