package com.example.springCoinMarket.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

@Service
public class FiatCurrencyService {
    private String url = "https://www.cbr-xml-daily.ru/daily.xml";

    public String getPrice(String currency) throws IOException {
        HashMap<String, String> fiats = getFiat();
        return fiats.get(currency);
    }

    public HashMap<String, String> getFiat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

        String line = reader.readLine();
        reader.close();

        HashMap<String, String> fiats = new HashMap<>();
        String[] parts = line.split("</Valute>");

        for (int i = 0; i < parts.length; i++) {
            String CharCode = null, Value = null;

            int startIndex1 = parts[i].indexOf("<CharCode>");
            int endIndex1 = parts[i].indexOf("</CharCode>");

            if (startIndex1 != -1 || endIndex1 != -1) {
                CharCode = parts[i].substring(startIndex1 + "<CharCode>".length(), endIndex1);
            }

            int startIndex2 = parts[i].indexOf("<Value>");
            int endIndex2 = parts[i].indexOf("</Value>");

            if (startIndex2 != -1 || endIndex2 != -1) {
                Value = parts[i].substring(startIndex2 + "<Value>".length(), endIndex2);
            }
            if (CharCode != null && Value != null) {
                fiats.put(CharCode, Value);
            }
        }

        return fiats;
    }
}
