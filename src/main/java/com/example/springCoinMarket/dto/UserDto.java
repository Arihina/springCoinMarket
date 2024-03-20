package com.example.springCoinMarket.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer walletId;
}
