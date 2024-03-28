package com.example.springCoinMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class WalletDto {
    private Integer id;
    private Long userId;
    private List<Integer> coinWalletIds;
}
