package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.Wallet;
import com.example.springCoinMarket.dto.WalletDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WalletConverter {
    public static Wallet toModel(WalletDto walletDto) {
        Wallet wallet = new Wallet();
        wallet.setId(walletDto.getId());
        wallet.setUserId(walletDto.getUserId());
        wallet.setCoinWalletIds(null);
        wallet.setTransactionIds(null);

        return wallet;
    }

    public static WalletDto toDto(Wallet wallet) {
        return WalletDto.builder()
                .id(wallet.getId())
                .coinWalletIds(wallet.getCoinWalletIds())
                .userId(wallet.getUserId())
                .build();
    }
}
