package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.ExchangeLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeLotRepository extends JpaRepository<ExchangeLot, Long> {
}
