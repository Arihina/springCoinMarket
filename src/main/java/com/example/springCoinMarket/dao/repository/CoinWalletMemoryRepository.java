package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.CoinWallet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CoinWalletRepository {
    private final Map<Long, CoinWallet> coinWallets = new HashMap<>();


    public Map<Long, CoinWallet> getCoinWallets() {
        return coinWallets;
    }

    public void deleteCoinWallet(Long id) {
        if (coinWallets.get(id) != null) {
            coinWallets.remove(id);
        }
    }

    public CoinWallet getCoinWallet(Long id) {
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
