package com.example.springCoinMarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// TODO
@RestController
public class CryptocurrencyController {
    private String url = "https://api.binance.com/api/v3/ticker/price?symbol=";

    @GetMapping("/crypto/price/{currency}")
    public String getPrice(@PathVariable String currency) {
        String newUrl = url + currency;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(newUrl, String.class);

        return response;
    }

    @GetMapping("/crypto")
    public String[] getCrypto()
    {
        return new String[]{"BTCUSDT", "ETHUSDT", "BNBUSDT"};
    }
}
