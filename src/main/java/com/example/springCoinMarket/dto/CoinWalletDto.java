package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CoinWalletDto {
    private Integer id;
    private Integer coinId;
    private String coinName;
    private Integer countCoin;
}
