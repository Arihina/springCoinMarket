package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Coin;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CoinMemoryRepository {
    private final HashMap<Integer, Coin> coins = new HashMap<>();

    public HashMap<Integer, Coin> getCoins() {
        return coins;
    }

    public Coin getCoin(Integer id) {
        if (coins.get(id) != null) {
            return coins.get(id);
        }
        return null;
    }

    public void addCoin(Coin coin) {
        coins.put(coin.getId(), coin);
    }
}
