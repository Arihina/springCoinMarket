package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.service.FiatCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class FiatCurrencyController {
    private final FiatCurrencyService service;

    @Autowired
    public FiatCurrencyController(FiatCurrencyService fiatService) {
        this.service = fiatService;
    }

    @GetMapping("/fiat/price/{currency}")
    public Double getPrice(@PathVariable String currency) throws IOException {
        return service.getPrice(currency);
    }

    @GetMapping("/fiat")
    public HashMap<String, Double> getFiat() throws IOException {
        return service.getAllLots();
    }
}
