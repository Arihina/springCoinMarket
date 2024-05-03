package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
