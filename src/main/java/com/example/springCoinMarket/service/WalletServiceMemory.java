package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.WalletDao;
import com.example.springCoinMarket.dao.repository.WalletMemoryRepository;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WalletServiceMemory implements WalletService {
    private final WalletMemoryRepository repository;

    public WalletServiceMemory() {
        repository = new WalletMemoryRepository();
    }

    @Override
    public HashMap<Integer, String> getWallets() {
        HashMap<Integer, WalletDao> walletsDao = repository.getWallets();
        HashMap<Integer, String> walletsInfo = new HashMap<>();

        for (Integer key : walletsDao.keySet()) {
            if (walletsDao.get(key).getCoinsId() != null) {
                StringBuilder coins = new StringBuilder();
                for (Integer coin : walletsDao.get(key).getCoinsId()) {
                    coins.append(" ").append(coin.toString()).append(" ");
                }

                String info = String.format("""
                                user id: %d
                                id: %d
                                coins id: %s""",
                        walletsDao.get(key).getUserId(), walletsDao.get(key).getId(), coins.toString());

                walletsInfo.put(key, info);
            } else {
                String info = String.format("""
                                user id: %d
                                id: %d
                                coins id: no coins in wallet""",
                        walletsDao.get(key).getUserId(), walletsDao.get(key).getId());

                walletsInfo.put(key, info);
            }
        }

        return walletsInfo;
    }

    @Override
    public String getWallet(int id) {
        WalletDao walletDao = repository.getWallet(id);


        WalletDto walletDto = WalletDto.builder()
                .userId(walletDao.getUserId())
                .coinsId(walletDao.getCoinsId())
                .build();


        var coins = walletDto.getCoinsId();


        if (coins != null) {
            StringBuilder coinsInfo = new StringBuilder();
            for (var coin : coins) {
                coinsInfo.append(coin.toString()).append(" ");
            }


            return String.format("""
                    user id: %d
                    coins id: %s
                    """, walletDto.getUserId(), coinsInfo.toString()
            );
        } else {
            return String.format("""
                    user id: %d
                    coins id: no coins in wallet
                    """, walletDto.getUserId());
        }

    }

    @Override
    public void createWallet(WalletDao walletDao) {
        repository.setWallet(walletDao);
    }

    @Override
    public void deleteWallet(int id) {
        repository.deleteWallet(id);
    }
}
