package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinWalletRepository;
import com.example.springCoinMarket.dto.CashInDto;
import com.example.springCoinMarket.dto.CashOutDto;
import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private final CoinWalletRepository repository;

    @Autowired
    public BalanceService(CoinWalletRepository repository) {
        this.repository = repository;
    }

    public void cashIn(CashInDto cashInDto) {
        CoinWallet coinWallet = repository.getCoinWallet(cashInDto.getCoinWalletId());
        if (coinWallet != null) {
            Integer oldCountCoin = coinWallet.getCountCoin();
            coinWallet.setCountCoin(oldCountCoin + cashInDto.getCountCoin());
            // repository.updateCoinWallet(coinWallet);
        }
    }

    public void cashOut(CashOutDto cashOutDto) {
        CoinWallet coinWallet = repository.getCoinWallet(cashOutDto.getCoinWalletId());
        if (coinWallet != null) {
            Integer countCoin = coinWallet.getCountCoin();
            if (countCoin - cashOutDto.getCountCoin() >= 0) {
                coinWallet.setCountCoin(countCoin - cashOutDto.getCountCoin());
                // repository.updateCoinWallet(coinWallet);
            }
        }
    }
}
