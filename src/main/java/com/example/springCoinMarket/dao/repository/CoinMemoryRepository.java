package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.CoinDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CoinMemoryRepository {
    private final HashMap<Integer, CoinDao> coins = new HashMap<>();

    public HashMap<Integer, CoinDao> getCoins() {
        return coins;
    }

    public CoinDao getCoin(int id) {
        if (coins.get(id) != null) {
            return coins.get(id);
        }
        return null;
    }

    public void addCoin(CoinDao coinDao) {
        coins.put(coinDao.getId(), coinDao);
    }
}
