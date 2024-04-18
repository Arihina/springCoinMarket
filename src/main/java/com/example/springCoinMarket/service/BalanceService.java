package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinWalletRepository;
import com.example.springCoinMarket.dto.CashInDto;
import com.example.springCoinMarket.dto.CashOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceService {
    private final CoinWalletRepository repository;

    @Autowired
    public BalanceService(CoinWalletRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void cashIn(CashInDto cashInDto) {
        CoinWallet coinWallet = repository.findById(cashInDto.getCoinWalletId()).get();
        var oldCountCoin = coinWallet.getCountCoin();
        coinWallet.setCountCoin(oldCountCoin + cashInDto.getCountCoin());
    }

    @Transactional
    public void cashOut(CashOutDto cashOutDto) {
        CoinWallet coinWallet = repository.findById(cashOutDto.getCoinWalletId()).get();
        Integer countCoin = coinWallet.getCountCoin();
        if (countCoin - cashOutDto.getCountCoin() >= 0) {
            coinWallet.setCountCoin(countCoin - cashOutDto.getCountCoin());
        }
    }
}
