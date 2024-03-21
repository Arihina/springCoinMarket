package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Wallet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class WalletMemoryRepository {
    private final HashMap<Integer, Wallet> wallets;

    public WalletMemoryRepository() {
        wallets = new HashMap<>();
    }

    public HashMap<Integer, Wallet> getWallets() {
        return wallets;
    }

    public Wallet getWallet(Integer id) {
        if (wallets.get(id) != null)
        {
            return wallets.get(id);
        }
        return null;
    }

    public void setWallet(Wallet wallet) {
        wallets.put(wallet.getId(), wallet);
    }

    public void deleteWallet(Integer id) {
        if (wallets.get(id) != null) {
            wallets.remove(id);
        }
    }
}
