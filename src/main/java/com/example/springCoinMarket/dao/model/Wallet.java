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
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<CoinWallet> coinWallets = new ArrayList<>();

    public void add(CoinWallet coinWallet)
    {
        coinWallets.add(coinWallet);
        coinWallet.setWallet(this);
    }

    public void del(CoinWallet coinWallet)
    {
        coinWallets.remove(coinWallet);
        coinWallet.setWallet(null);
    }

    // @OneToMany(mappedBy = "id")
    // private List<Long> transactionIds;

    @Transient
    private List<Long> coinWalletIds;
    @Transient
    private Long userId;
}
