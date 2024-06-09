package com.example.springCoinMarket.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@UtilityClass
public class FiatParser {
    public static HashMap<String, Double> getFiatRate() {
        var rate = new HashMap<String, Double>();

        try {
            URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
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

            var nodes = mapper.readTree(jsonResponse);
            String valutes = nodes.get("Valute").toString();

            nodes = mapper.readTree(valutes);
            for (var node : nodes) {
                rate.put(node.get("CharCode").toString().replaceAll("\"", ""),
                        node.get("Value").asDouble());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rate;
    }
}
