package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CoinDto;
import com.example.springCoinMarket.service.CoinService;
import com.example.springCoinMarket.service.CoinServiceMemory;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/coin/adding")
    public void addCoin(@RequestBody CoinDto coinDto) {
        service.addCoin(coinDto);
    }

    @DeleteMapping("/coin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoin(@PathVariable Integer id) {
        service.deleteCoin(id);
    }

    @PutMapping("/coin/data_updating")
    public void updateCoin(@RequestBody CoinDto coinDto) {
        service.updateCoin(coinDto);
    }
}
