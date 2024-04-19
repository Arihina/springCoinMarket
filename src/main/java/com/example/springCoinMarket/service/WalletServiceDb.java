package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.WalletConverter;
import com.example.springCoinMarket.dao.repository.WalletRepository;
import com.example.springCoinMarket.dto.WalletDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class WalletServiceDb implements WalletService {
    private final WalletRepository repository;

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public WalletDto getWallet(Long id) {
        return WalletConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    @Transactional
    public void createWallet(WalletDto WalletDao) {
        repository.save(WalletConverter.toModel(WalletDao));
    }

    @Override
    @Transactional
    public void deleteWallet(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void addCoinWallet(Long id, Long walletId) {
    }
}
