package com.example.springCoinMarket.dao.model;


import lombok.*;

@Data
public class User {
    private String name;
    private Integer id;
    private String password;
    private String email;
    private Integer walletId;
}
