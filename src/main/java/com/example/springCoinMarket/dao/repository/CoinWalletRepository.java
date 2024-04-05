package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.CoinWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinWalletRepository extends JpaRepository<CoinWallet, Long> {
}
