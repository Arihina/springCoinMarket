package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dto.CoinWalletDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CoinWalletConverter {
    public static CoinWallet toModel(CoinWalletDto coinWalletDto) {
        CoinWallet coinWallet = new CoinWallet();
        coinWallet.setId(coinWalletDto.getId());
        coinWallet.setCoinId(coinWalletDto.getCoinId());
        coinWallet.setCoinName(coinWalletDto.getCoinName());
        coinWallet.setCountCoin(coinWalletDto.getCountCoin());

        return coinWallet;
    }

    public static CoinWalletDto toDto(CoinWallet coinWallet) {

        return CoinWalletDto.builder()
                .id(coinWallet.getId())
                .coinId(coinWallet.getCoinId())
                .countCoin(coinWallet.getCountCoin())
                .coinName(coinWallet.getCoinName())
                .build();
    }
}
