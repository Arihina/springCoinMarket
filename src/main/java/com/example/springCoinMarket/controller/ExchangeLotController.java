package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.ExchangeLotDto;
import com.example.springCoinMarket.service.ExchangeLotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class ExchangeLotController {
    private final ExchangeLotService service;

    @GetMapping("/exchangeLot")
    public HashMap<Long, ExchangeLotDto> getLots() {
        return service.getLots();
    }

    @GetMapping("/exchangeLot/{id}")
    public ExchangeLotDto getLot(@PathVariable Long id) {
        return service.getLot(id);
    }

    @PostMapping("/exchangeLot")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLot(@RequestBody ExchangeLotDto exchangeLotDto) {
        service.add(exchangeLotDto);
    }

    @DeleteMapping("/exchangeLot/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLot(@PathVariable Long id) {
        service.delete(id);
    }
}
