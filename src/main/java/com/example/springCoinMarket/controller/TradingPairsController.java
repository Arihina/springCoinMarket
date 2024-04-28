package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.service.TradingPairsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TradingPairsController {
    private final TradingPairsService service;
}
