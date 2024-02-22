package com.example.springCoinMarket.dao.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public int getUserID() {
        return this.id;
    }

    public String name;
    private int id;
    public String password;
    public String email;
    public int walletNumber;

}
