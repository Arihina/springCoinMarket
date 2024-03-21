package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.CoinWallet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CoinWalletRepository {
    private final HashMap<Integer, CoinWallet> coinWallets;

    public CoinWalletRepository() {
        coinWallets = new HashMap<>();
    }

    public HashMap<Integer, CoinWallet> getCoinWallets() {
        return coinWallets;
    }

    public void deleteCoinWallet(Integer id) {
        if (coinWallets.get(id) != null) {
            coinWallets.remove(id);
        }
    }

    public CoinWallet getCoinWallet(Integer id) {
        if (coinWallets.get(id) != null) {
            return coinWallets.get(id);
        }
        return null;
    }

    public void updateCoinWallet(CoinWallet coinWallet) {
        if (coinWallets.get(coinWallet.getId()) != null) {
            coinWallets.put(coinWallet.getId(), coinWallet);
        }
    }

    public void addCoinWallet(CoinWallet coinWallet) {
        coinWallets.put(coinWallet.getId(), coinWallet);
    }
}
