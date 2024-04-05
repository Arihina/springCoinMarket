package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Long> {
}
