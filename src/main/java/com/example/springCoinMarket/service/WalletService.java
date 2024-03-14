package com.example.springCoinMarket.service;

import java.util.HashMap;

public interface WalletService {

    HashMap<Integer, String> getWallets();
    String getWallet(int id);
}
