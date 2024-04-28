package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.TradingPair;
import com.example.springCoinMarket.service.CryptocurrencyService;
import com.example.springCoinMarket.service.FiatCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CryptocurrencyController {
    private final CryptocurrencyService service;

    @Autowired
    public CryptocurrencyController(CryptocurrencyService fiatService) {
        this.service = fiatService;
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
