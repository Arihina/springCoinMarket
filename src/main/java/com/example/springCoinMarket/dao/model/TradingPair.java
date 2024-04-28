package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tradingpairs")
public class TradingPair {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
