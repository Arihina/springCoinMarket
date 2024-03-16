package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.WalletDao;
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
        HashMap<Integer, WalletDao> walletsDao = repository.getWallets();
        HashMap<Integer, WalletDto> walletsDto = new HashMap<>();

        for (Integer key : walletsDao.keySet()) {
            WalletDto modelDto = WalletDto.builder()
                    .walletId(walletsDao.get(key).getId())
                    .userId(walletsDao.get(key).getUserId())
                    .build();

            if (walletsDao.get(key).getCoinsId() != null) {
                for (Integer coin : walletsDao.get(key).getCoinsId()) {
                    modelDto.getCoinsId().add(coinRepository.getCoin(coin).getId());
                }
            }
            walletsDto.put(key, modelDto);

        }

        return walletsDto;
    }

    @Override
    public WalletDto getWallet(int id) {
        WalletDao walletDao = repository.getWallet(id);

        return WalletDto.builder()
                .userId(walletDao.getUserId())
                .coinsId(walletDao.getCoinsId())
                .build();
    }

    @Override
    public void createWallet(WalletDto walletDto) {
        WalletDao walletDao = new WalletDao();
        walletDao.setId(walletDto.getWalletId());
        walletDao.setUserId(walletDto.getUserId());
        walletDao.setCoinsId(null);
        walletDao.setTransactionsId(null);

        repository.setWallet(walletDao);
    }

    @Override
    public void deleteWallet(int id) {
        repository.deleteWallet(id);
    }
}
