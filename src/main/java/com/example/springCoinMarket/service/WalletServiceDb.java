package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.WalletConverter;
import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinWalletRepository;
import com.example.springCoinMarket.dao.repository.WalletRepository;
import com.example.springCoinMarket.dto.WalletDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class WalletServiceDb implements WalletService {
    private final WalletRepository repository;
    private final CoinWalletRepository coinWalletRepository;
    @Override
    public HashMap<Long, WalletDto> getWallets() {
        var wallets = repository.findAll();
        HashMap<Long, WalletDto> walletsDto = new HashMap<>();

        for (var wallet : wallets) {
            var modelDto = WalletConverter.toDto(wallet);
            walletsDto.put(modelDto.getId(), modelDto);
        }

        return walletsDto;
    }

    @Override
    public WalletDto getWallet(Long id) {
        return WalletConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    public void createWallet(WalletDto WalletDao) {
        repository.save(WalletConverter.toModel(WalletDao));
    }

    @Override
    public void deleteWallet(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addCoinWallet(Long id, Long walletId) {

    }
}
