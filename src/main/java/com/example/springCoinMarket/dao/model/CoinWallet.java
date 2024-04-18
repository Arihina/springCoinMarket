package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coinwallet")
public class CoinWallet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Long coinId;
    @Column(name = "count_coin")
    private Integer countCoin;
    @Column(name = "coin_name")
    private String coinName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coin_id")
    private Coin coin;
}
