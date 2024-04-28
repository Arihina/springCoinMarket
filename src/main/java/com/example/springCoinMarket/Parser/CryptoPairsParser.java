package com.example.springCoinMarket.Parser;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CryptoPairsParser {
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

            var pair = match.substring(indexStart + "{\"symbol\":\"".length(), indexEnd);

            if (pair.contains("USDT")) {
                currencies.add(pair);
            }
        }

        return currencies;
    }
}
