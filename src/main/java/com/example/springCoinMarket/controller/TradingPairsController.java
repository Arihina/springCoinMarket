package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dao.model.TradingPair;
import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.service.TradingPairsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class TradingPairsController {
    private final TradingPairsService service;

    @GetMapping("/trading_pairs")
    public HashMap<Integer, TradingPair> getTradingPairs() {
        return service.getTradingPairs();
    }

    @GetMapping("/trading_pairs/{id}")
    public TradingPair getPair(@PathVariable Integer id) {
        return service.getTradingPair(id);
    }

    @PostMapping("/trading_pairs/adding")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPair(@RequestBody TradingPair tradingPair) {
        service.createTradingPair(tradingPair);
    }

    @DeleteMapping("/trading_pairs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePair(@PathVariable Integer id) {
        service.deleteTradingPair(id);
    }
}
