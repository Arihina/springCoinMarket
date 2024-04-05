package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.CoinDto;

import java.util.HashMap;

public interface CoinService {
    HashMap<Long, CoinDto> getCoins();

    CoinDto getCoin(Long id);

    void addCoin(CoinDto coinDto);

    void deleteCoin(Long id);

    void updateCoin(CoinDto coinDto);
}
