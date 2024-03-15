package com.example.springCoinMarket.dao.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDao {
    private String name;
    private int id;
    private String password;
    private String email;
    private int walletId;
}
