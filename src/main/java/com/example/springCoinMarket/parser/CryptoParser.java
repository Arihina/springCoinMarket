package com.example.springCoinMarket.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@UtilityClass
public class CryptoParser {
    public static HashMap<String, Double> getCryptoRate() {
        var rate = new HashMap<String, Double>();

        try {
            URL url = new URL("https://api.binance.com/api/v3/ticker/price");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String jsonResponse = response.toString();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode json = mapper.readTree(jsonResponse);

            var pairs = json.findValues("symbol");
            var prices = json.findValues("price");

            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).toString().contains("USDT")) {
                    rate.put(pairs.get(i).toString(), prices.get(i).asDouble());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rate;
    }
}
