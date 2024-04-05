package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CoinWalletDto {
    private Long id;
    private Long coinId;
    private String coinName;
    private Integer countCoin;
}
