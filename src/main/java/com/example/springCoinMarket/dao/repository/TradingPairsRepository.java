package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.TradingPair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingPairsRepository extends JpaRepository<TradingPair, Integer> {
}
