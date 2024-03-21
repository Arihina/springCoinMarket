package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.CoinWalletConverter;
import com.example.springCoinMarket.dao.model.CoinWallet;
import com.example.springCoinMarket.dao.repository.CoinMemoryRepository;
import com.example.springCoinMarket.dao.repository.CoinWalletRepository;
import com.example.springCoinMarket.dto.CoinWalletDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CoinWalletServiceMemory implements CoinWalletService {
    private final CoinWalletRepository repository;

    public CoinWalletServiceMemory() {
        repository = new CoinWalletRepository();
    }

    @Override
    public HashMap<Integer, CoinWalletDto> getCoinWallets() {
        HashMap<Integer, CoinWalletDto> coinWalletsDto = new HashMap<>();
        HashMap<Integer, CoinWallet> coinWallets = repository.getCoinWallets();

        for (Integer key : coinWallets.keySet()) {
            var modelDto = CoinWalletConverter.toDto(coinWallets.get(key));
            coinWalletsDto.put(key, modelDto);
        }

        return coinWalletsDto;
    }

    @Override
    public CoinWalletDto getCoinWallet(Integer id) {
        CoinWallet coinWallet = repository.getCoinWallet(id);

        return CoinWalletConverter.toDto(coinWallet);
    }

    @Override
    public void addCoinWallet(CoinWalletDto coinWalletDto) {
        repository.addCoinWallet(CoinWalletConverter.toModel(coinWalletDto));
    }

    @Override
    public void deleteCoinWallet(Integer id) {
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
