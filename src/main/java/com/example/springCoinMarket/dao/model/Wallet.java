package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoinWallet> coinWallets;


    // @OneToMany(mappedBy = "id")
    // private List<Long> transactionIds;

    @Transient
    private List<Long> coinWalletIds;
    @Transient
    private Long userId;
}
