package com.example.springCoinMarket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CryptocurrencyService {
    private String url = "https://api.binance.com/api/v3/ticker/price?symbol=";

    public String getPrice(String currency) {
        String newUrl = url + currency;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(newUrl, String.class);

        return response;
    }

    public ArrayList<String> getCrypto() {
        String urlInfo = "https://api.binance.com/api/v1/exchangeInfo";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(urlInfo, String.class);

        var currencies = new ArrayList<String>();

        Pattern pattern = Pattern.compile("\\{\"symbol\":\"[^\"]+\",\"status\"");
        Matcher matcher = pattern.matcher(response);

        while (matcher.find()) {
            String match = matcher.group();
            int indexStart = match.indexOf("{\"symbol\":\"");
            int indexEnd = match.indexOf("\",\"status\"");

            currencies.add(match.substring(indexStart + "{\"symbol\":\"".length(), indexEnd));
        }

        return currencies;
    }
}
