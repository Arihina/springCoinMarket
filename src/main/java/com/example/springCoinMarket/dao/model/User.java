package com.example.springCoinMarket.dao.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    private Integer walletId;
}
