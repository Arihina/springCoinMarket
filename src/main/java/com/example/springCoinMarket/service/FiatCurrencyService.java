package com.example.springCoinMarket.service;

import com.example.springCoinMarket.parser.CryptoParser;
import com.example.springCoinMarket.parser.FiatParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

@Service
public class FiatCurrencyService {
    private String url = "https://www.cbr-xml-daily.ru/daily.xml";

    public Double getPrice(String currency) {
        HashMap<String, Double> fiats = getAllLots();
        return fiats.get(currency);
    }

    public HashMap<String, Double> getAllLots() {
        return FiatParser.getFiatRate();
    }
}
