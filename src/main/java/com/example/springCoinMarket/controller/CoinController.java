package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.service.CoinService;
import com.example.springCoinMarket.service.CoinServiceMemory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoinController {
    private final CoinService service;

    public CoinController() {
        service = new CoinServiceMemory();
    }

    @GetMapping("/coin")
    public HashMap<Integer, CoinDto> getCoins() {
        return service.getCoins();
    }

    @GetMapping("/coin/{id}")
    public CoinDto getCoin(@PathVariable Integer id) {
        return service.getCoin(id);
    }

    @PostMapping("/coin/add")
    public void addCoin(@RequestBody CoinDto coinDto) {
        service.addCoin(coinDto);
    }
}
