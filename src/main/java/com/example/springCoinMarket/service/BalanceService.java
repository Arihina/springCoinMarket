package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    public void cashIn(CoinDto coinDto, WalletDto walletDto) {
        var coinsId = walletDto.getCoinsId();
        for (Integer coinId : coinsId) {

        }
    }

    public void cashOut(CoinDto coinDto, WalletDto walletDto) {
        var coinsId = walletDto.getCoinsId();
        for (Integer coinId : coinsId) {

        }
    }
}
