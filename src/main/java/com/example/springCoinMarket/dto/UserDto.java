package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private String name;
    private int id;
    private String password;
    private String email;
    private int walletId;
}
