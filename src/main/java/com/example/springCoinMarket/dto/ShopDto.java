package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShopDto {
    private Long id;
    private String currency;
}
