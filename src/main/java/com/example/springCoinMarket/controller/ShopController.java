package com.example.springCoinMarket.controller;

import com.example.springCoinMarket.dto.CashDto;
import com.example.springCoinMarket.dto.ShopDto;
import com.example.springCoinMarket.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class ShopController {
    private final ShopService service;

    @GetMapping("/shop")
    public HashMap<Long, ShopDto> getShops() {
        return service.getShops();
    }

    @GetMapping("/shop/{id}")
    public ShopDto getShop(@PathVariable Long id) {
        return service.getShop(id);
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShop(@RequestBody ShopDto shopDto) {
        service.add(shopDto);
    }

    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/shop/{id}")
    public void replenish(@RequestBody CashDto cashDto, @PathVariable Long id) {
        service.replenish(cashDto, id);
    }
}
