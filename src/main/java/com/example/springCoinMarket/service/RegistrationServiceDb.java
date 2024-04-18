package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.UserConverter;
import com.example.springCoinMarket.converter.WalletConverter;
import com.example.springCoinMarket.dao.repository.UserRepository;
import com.example.springCoinMarket.dao.repository.WalletRepository;
import com.example.springCoinMarket.dto.UserDto;
import com.example.springCoinMarket.dto.WalletDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistrationServiceDb {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Transactional
    public void save(UserDto userDto) {
        WalletDto walletDto = WalletDto.builder().
                id(userDto.getWalletId()).
                coinWalletIds(null).
                userId(userDto.getId()).
                build();

        var userModel = UserConverter.toModel(userDto);
        var walletModel = WalletConverter.toModel(walletDto);

        userModel.setWallet(walletModel);

        walletRepository.save(walletModel);
        userRepository.save(userModel);
    }
}
