package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.User;
import com.example.springCoinMarket.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static User toModel(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        //user.setWalletId(user.getWallet().getId());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .id(user.getId())
                //.walletId(user.getWallet().getId())
                .build();
    }

    public static UserDto toFullDto(User user) {
        return UserDto.builder().
                name(user.getName()).
                email(user.getEmail()).
                password(user.getPassword()).
                id(user.getId()).
                //walletId(user.getWallet().getId()).
                build();
    }
}
