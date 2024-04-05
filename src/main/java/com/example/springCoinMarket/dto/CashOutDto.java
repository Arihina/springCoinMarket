package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CashOutDto {
    private Integer id;
    private Long coinWalletId;
    private Long coinId;
    private Integer countCoin;
}
