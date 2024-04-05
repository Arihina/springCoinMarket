package com.example.springCoinMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class WalletDto {
    private Long id;
    private Long userId;
    private List<Long> coinWalletIds;
}
