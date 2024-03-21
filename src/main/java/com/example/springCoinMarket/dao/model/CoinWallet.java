package com.example.springCoinMarket.dao.model;

import lombok.Data;

@Data
public class CoinWallet {
    private Integer id;
    private Integer coinId;
    private Integer countCoin;
    private String coinName;
}
