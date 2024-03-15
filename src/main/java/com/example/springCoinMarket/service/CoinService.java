package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.CoinDto;

import java.util.HashMap;

public interface CoinService {
    HashMap<Integer, CoinDto> getCoins();

    CoinDto getCoin(int id);

    void addCoin(CoinDto coinDto);
}
