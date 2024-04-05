package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
