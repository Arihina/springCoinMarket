package com.example.springCoinMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Builder
@Getter
@AllArgsConstructor
public class WalletDto {
    private int walletId;
    private int userId;
    private ArrayList<Integer> coinsId;
}
