package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CashInDto;
import com.example.springCoinMarket.dto.CashOutDto;
import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.dto.CoinWalletDto;
import com.example.springCoinMarket.service.BalanceService;
import com.example.springCoinMarket.service.CoinServiceMemory;
import com.example.springCoinMarket.service.CoinWalletService;
import com.example.springCoinMarket.service.CoinWalletServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BalanceController {
    private final BalanceService service;

    public BalanceController() {
        service = new BalanceService();
    }

    @PutMapping("/cash_in")
    public void cashIn(@RequestBody CashInDto cashInDto) {
        service.cashIn(cashInDto);
    }

    @PutMapping("/cash_out")
    public void cashOut(@RequestBody CashOutDto cashOutDto) {
        service.cashOut(cashOutDto);
    }
}
