package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.WalletConverter;
import com.example.springCoinMarket.dao.model.Wallet;
import com.example.springCoinMarket.dao.repository.WalletMemoryRepository;
import com.example.springCoinMarket.dto.WalletDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WalletServiceMemory implements WalletService {
    private final WalletMemoryRepository repository;
    private final CoinWalletService service;

    public WalletServiceMemory() {
        repository = new WalletMemoryRepository();
        service = new CoinWalletServiceMemory();
    }

    @Override
    public HashMap<Integer, WalletDto> getWallets() {
        HashMap<Integer, Wallet> walletsDao = repository.getWallets();
        HashMap<Integer, WalletDto> walletsDto = new HashMap<>();

        for (Integer key : walletsDao.keySet()) {
            var modelDto = WalletConverter.toDto(walletsDao.get(key));

            if (walletsDao.get(key).getCoinWalletIds() != null) {
                for (Integer id : walletsDao.get(key).getCoinWalletIds()) {
                    modelDto.getCoinWalletIds().add(service.getCoinWallet(id).getCoinId());
                }
            }
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

    // TODO check it (fix?)
    public void addCoinWallet(Integer id) {
        Wallet wallet = repository.getWallet(id);
        var ids = wallet.getCoinWalletIds();
        ids.add(id);
        wallet.setCoinWalletIds(ids);
    }
}
