package com.example.springCoinMarket.dao.repository;

import com.example.springCoinMarket.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
