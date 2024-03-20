package com.example.springCoinMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class WalletDto {
    private Integer walletId;
    private Integer userId;
    private List<Integer> coinsIds;
}
