package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.WalletDao;

import java.util.HashMap;

public interface WalletService {

    HashMap<Integer, String> getWallets();
    String getWallet(int id);

    void createWallet(WalletDao walletDao);

    void deleteWallet(int id);
}
