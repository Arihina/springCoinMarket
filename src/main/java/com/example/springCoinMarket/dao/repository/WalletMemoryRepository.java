package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.UserDao;
import com.example.springCoinMarket.dao.model.WalletDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class WalletMemoryRepository {
    private final HashMap<Integer, WalletDao> wallets = new HashMap<>();


    public HashMap<Integer, WalletDao> getWallets() {
        return wallets;
    }

    public WalletDao getWallet(int id) {
        if (wallets.get(id) != null)
        {
            return wallets.get(id);
        }
        return null;
    }
}
