package com.example.springCoinMarket.dao.model;

import lombok.*;


import java.util.List;

@Data
public class Wallet {
    private Long userId;
    private Integer id;
    private List<Integer> coinWalletIds;
    private List<Integer> transactionIds;
}
