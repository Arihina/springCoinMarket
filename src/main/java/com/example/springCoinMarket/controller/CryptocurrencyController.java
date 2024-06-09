package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.TradingPair;
import com.example.springCoinMarket.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CryptocurrencyController {
    private final CryptocurrencyService service;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService service) {
        this.service = service;
    }

    @GetMapping("/crypto/price/{currency}")
    public String getPrice(@PathVariable String currency) {
        return service.getPrice(currency);
    }

    @GetMapping("/crypto")
    public HashMap<Integer, TradingPair> getCrypto() {
        return service.getCrypto();
    }
}
