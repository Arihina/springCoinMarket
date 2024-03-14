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
            String coins = "";
            for (Integer coin : walletsDao.get(key).getCoinsId()) {
                coins += coin.toString() + " ";
            }

            String info = String.format(
                    """
                                    user id: %d
                                    id: %d
                                    coins id: %s
                            """,
                    walletsDao.get(key).getUserId(), walletsDao.get(key).getId(), coins);

            walletsInfo.put(key, info);
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
        String coinsInfo = "";
        for (var coin : coins) {
            coinsInfo += coin.toString() + " ";
        }

        return String.format("""
                user id: %d,
                coins id: %s
                """, walletDto.getUserId(), coinsInfo
        );
    }
}
