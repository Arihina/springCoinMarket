package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Builder
@Getter
public class WalletDto {
    private int walletId;
    private int userId;
    private ArrayList<Integer> coinsId;
}
