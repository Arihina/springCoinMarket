package com.example.springCoinMarket.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class WalletDao {
    private int userId;
    private int id;
    private ArrayList<Integer> coinsId;
    private ArrayList<Integer> transactionsId;
}
