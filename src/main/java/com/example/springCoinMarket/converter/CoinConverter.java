package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.Coin;
import com.example.springCoinMarket.dto.CoinDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CoinConverter {
    public static Coin toModel(CoinDto coinDto) {
        Coin coin = new Coin();
        coin.setId(coinDto.getId());
        coin.setCurrency(coinDto.getCurrency());
        coin.setQuantity(coinDto.getQuantity());

        return coin;
    }

    public static CoinDto toDto(Coin coin) {
        return CoinDto.builder()
                .id(coin.getId())
                .quantity(coin.getQuantity())
                .currency(coin.getCurrency())
                .build();

    }
}
