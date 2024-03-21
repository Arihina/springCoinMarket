package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.Wallet;
import com.example.springCoinMarket.dao.repository.CoinMemoryRepository;
import com.example.springCoinMarket.dao.repository.WalletMemoryRepository;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WalletServiceMemory implements WalletService {
    private final WalletMemoryRepository repository;
    private CoinMemoryRepository coinRepository;

    public WalletServiceMemory() {
        repository = new WalletMemoryRepository();
    }

    @Override
    public HashMap<Integer, WalletDto> getWallets() {
        HashMap<Integer, Wallet> walletsDao = repository.getWallets();
        HashMap<Integer, WalletDto> walletsDto = new HashMap<>();

        for (Integer key : walletsDao.keySet()) {
            WalletDto modelDto = WalletDto.builder()
                    .id(walletsDao.get(key).getId())
                    .userId(walletsDao.get(key).getUserId())
                    .build();

            if (walletsDao.get(key).getCoinIds() != null) {
                for (Integer coin : walletsDao.get(key).getCoinIds()) {
                    modelDto.getCoinsIds().add(coinRepository.getCoin(coin).getId());
                }
            }
            walletsDto.put(key, modelDto);

        }

        return walletsDto;
    }

    @Override
    public WalletDto getWallet(Integer id) {
        Wallet wallet = repository.getWallet(id);

        return WalletDto.builder()
                .userId(wallet.getUserId())
                .coinsIds(wallet.getCoinIds())
                .build();
    }

    @Override
    public void createWallet(WalletDto walletDto) {
        Wallet wallet = new Wallet();
        wallet.setId(walletDto.getId());
        wallet.setUserId(walletDto.getUserId());
        wallet.setCoinIds(null);
        wallet.setTransactionIds(null);

        repository.setWallet(wallet);
    }

    @Override
    public void deleteWallet(Integer id) {
        repository.deleteWallet(id);
    }
}
