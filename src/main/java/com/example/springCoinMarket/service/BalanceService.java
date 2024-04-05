package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinWalletMemoryRepository;
import com.example.springCoinMarket.dto.CashInDto;
import com.example.springCoinMarket.dto.CashOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private final CoinWalletMemoryRepository repository;

    @Autowired
    public BalanceService(CoinWalletMemoryRepository repository) {
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
