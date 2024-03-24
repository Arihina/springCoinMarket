package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.WalletConverter;
import com.example.springCoinMarket.dao.model.Wallet;
import com.example.springCoinMarket.dao.repository.WalletMemoryRepository;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceMemory implements WalletService {

    private final WalletMemoryRepository repository;
    private final CoinWalletService service;

    @Autowired
    public WalletServiceMemory(WalletMemoryRepository repository, CoinWalletService service) {
        this.repository = repository;
        this.service = service;
    }


    @Override
    public HashMap<Integer, WalletDto> getWallets() {
        Map<Integer, Wallet> walletsDao = repository.getWallets();
        HashMap<Integer, WalletDto> walletsDto = new HashMap<>();

        for (Integer key : walletsDao.keySet()) {
            var modelDto = WalletConverter.toDto(walletsDao.get(key));
            walletsDto.put(key, modelDto);

        }

        return walletsDto;
    }

    @Override
    public WalletDto getWallet(Integer id) {
        return WalletConverter.toDto(repository.getWallet(id));
    }

    @Override
    public void createWallet(WalletDto walletDto) {
        repository.setWallet(WalletConverter.toModel(walletDto));
    }

    @Override
    public void deleteWallet(Integer id) {
        repository.deleteWallet(id);
    }

    @Override
    public void addCoinWallet(Integer id, Integer walletId) {
        Wallet wallet = repository.getWallet(walletId);
        var ids = wallet.getCoinWalletIds();
        if (ids == null) {
            ids = new ArrayList<>();
        }
        ids.add(id);
        wallet.setCoinWalletIds(ids);
    }
}
