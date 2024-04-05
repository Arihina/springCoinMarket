package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.WalletDto;

import java.util.HashMap;

public interface WalletService {

    HashMap<Long, WalletDto> getWallets();
    WalletDto getWallet(Long id);

    void createWallet(WalletDto WalletDao);

    void deleteWallet(Long id);

    void addCoinWallet(Long id, Long walletId);
}
