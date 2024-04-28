package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.TradingPair;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class CryptocurrencyService {

    private final TradingPairsService service;

    public String getPrice(String currency) {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=";
        String newUrl = url + currency;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(newUrl, String.class);

        return response;
    }

    public HashMap<Integer, TradingPair> getCrypto() {
        return service.getTradingPairs();
    }
}
