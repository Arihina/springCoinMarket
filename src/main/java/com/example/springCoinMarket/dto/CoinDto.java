package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CoinDto {
    private int id;
    private int quantity;
    private String currency;
}
