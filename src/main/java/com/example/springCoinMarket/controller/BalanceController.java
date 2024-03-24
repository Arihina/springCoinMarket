package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CashInDto;
import com.example.springCoinMarket.dto.CashOutDto;
import com.example.springCoinMarket.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    private final BalanceService service;

    @Autowired
    public BalanceController(BalanceService service) {
        this.service = service;
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
