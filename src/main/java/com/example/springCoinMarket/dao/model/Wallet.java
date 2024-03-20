package com.example.springCoinMarket.dao.model;

import lombok.*;


import java.util.List;

@Data
public class Wallet {
    private Integer userId;
    private Integer id;
    private List<Integer> coinIds;
    private List<Integer> transactionIds;
}
