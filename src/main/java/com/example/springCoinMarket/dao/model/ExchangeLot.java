package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "exchangelot")
public class ExchangeLot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currencyin")
    private String currencyIn;
    @Column(name = "currencyout")
    private String currencyOut;
}
