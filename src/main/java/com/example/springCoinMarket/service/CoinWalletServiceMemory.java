package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.CoinWalletConverter;
import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinWalletMemoryRepository;
import com.example.springCoinMarket.dto.CoinWalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoinWalletServiceMemory implements CoinWalletService {
    private final CoinWalletMemoryRepository repository;

    @Autowired
    public CoinWalletServiceMemory(CoinWalletMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public HashMap<Long, CoinWalletDto> getCoinWallets() {
        HashMap<Long, CoinWalletDto> coinWalletsDto = new HashMap<>();
        Map<Long, CoinWallet> coinWallets = repository.getCoinWallets();

        for (var key : coinWallets.keySet()) {
            var modelDto = CoinWalletConverter.toDto(coinWallets.get(key));
            coinWalletsDto.put(key, modelDto);
        }

        return coinWalletsDto;
    }

    @Override
    public CoinWalletDto getCoinWallet(Long id) {
        CoinWallet coinWallet = repository.getCoinWallet(id);

        return CoinWalletConverter.toDto(coinWallet);
    }

    @Override
    public void addCoinWallet(CoinWalletDto coinWalletDto) {
        repository.addCoinWallet(CoinWalletConverter.toModel(coinWalletDto));
    }

    @Override
    public void deleteCoinWallet(Long id) {
        repository.deleteCoinWallet(id);
    }

    @Override
    public void updateCoinWallet(CoinWalletDto coinWalletDto) {
        CoinWallet coinWallet = new CoinWallet();
        coinWallet.setId(coinWalletDto.getId());
        coinWallet.setCountCoin(coinWalletDto.getCountCoin());
        coinWallet.setCoinId(coinWalletDto.getCoinId());

        repository.updateCoinWallet(coinWallet);
    }
}
