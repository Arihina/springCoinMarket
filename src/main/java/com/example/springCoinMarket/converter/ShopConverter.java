package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.Shop;
import com.example.springCoinMarket.dto.ShopDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShopConverter {
    public static Shop toModel(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setId(shop.getId());
        shop.setCurrency(shopDto.getCurrency());
        shop.setQuantity(0);

        return shop;
    }

    public static ShopDto toDto(Shop shop) {
        return ShopDto.builder().
                id(shop.getId()).
                currency(shop.getCurrency()).
                build();
    }
}
