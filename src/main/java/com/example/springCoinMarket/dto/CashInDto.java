package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CashInDto {
    private Integer id;
    private Integer coinWalletId;
    private Integer coinId;
    private Integer countCoin;
}
