package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table(name = "coin")
public class Coin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "currency")
    private String currency;

    @OneToMany(mappedBy = "coin", cascade = CascadeType.ALL)
    private List<CoinWallet> coinWallets;
}
