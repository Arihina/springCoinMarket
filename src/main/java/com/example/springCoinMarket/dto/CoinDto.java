package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CoinDto {
    private Long id;
    private Double quantity;
    private String currency;
}
