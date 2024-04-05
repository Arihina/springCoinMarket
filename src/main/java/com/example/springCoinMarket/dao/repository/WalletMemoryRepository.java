package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Wallet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WalletMemoryRepository {
    private final Map<Long, Wallet> wallets = new HashMap<>();


    public Map<Long, Wallet> getWallets() {
        return wallets;
    }

    public Wallet getWallet(Long id) {
        if (wallets.get(id) != null) {
            return wallets.get(id);
        }
        return null;
    }

    public void setWallet(Wallet wallet) {
        wallets.put(wallet.getId(), wallet);
    }

    public void deleteWallet(Long id) {
        if (wallets.get(id) != null) {
            wallets.remove(id);
        }
    }
}
