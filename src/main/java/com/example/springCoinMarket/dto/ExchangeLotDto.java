package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExchangeLotDto {
    private Long id;
    private String currencyIn;
    private String currencyOut;
    private Double rate;
}
