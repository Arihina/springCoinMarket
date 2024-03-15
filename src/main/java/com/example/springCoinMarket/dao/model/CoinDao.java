package com.example.springCoinMarket.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoinDao {
    private int id;
    private int quantity;
    private String currency;
}
