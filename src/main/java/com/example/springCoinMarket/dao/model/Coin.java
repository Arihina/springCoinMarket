package com.example.springCoinMarket.dao.model;

import lombok.*;


@Data
public class Coin {
    private Integer id;
    private Double quantity;
    private String currency;
}
