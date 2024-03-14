package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Builder
@Getter
public class WalletDto {
    private int userId;
    private ArrayList<Integer> coinsId;
}
