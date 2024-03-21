package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.Coin;
import com.example.springCoinMarket.dao.repository.CoinMemoryRepository;
import com.example.springCoinMarket.dto.CoinDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CoinServiceMemory implements CoinService {
    private final CoinMemoryRepository repository;

    public CoinServiceMemory() {
        repository = new CoinMemoryRepository();
    }

    @Override
    public HashMap<Integer, CoinDto> getCoins() {
        HashMap<Integer, CoinDto> coinsDto = new HashMap<>();
        HashMap<Integer, Coin> coinsDao = repository.getCoins();

        for (Integer key : coinsDao.keySet()) {
            CoinDto modelDto = CoinDto.builder()
                    .id(coinsDao.get(key).getId())
                    .quantity(coinsDao.get(key).getQuantity())
                    .currency(coinsDao.get(key).getCurrency())
                    .build();

            coinsDto.put(key, modelDto);
        }

        return coinsDto;
    }

    @Override
    public CoinDto getCoin(Integer id) {
        var modelDao = repository.getCoin(id);

        CoinDto modelDto = CoinDto.builder()
                .id(modelDao.getId())
                .quantity(modelDao.getQuantity())
                .currency(modelDao.getCurrency())
                .build();

        return modelDto;
    }

    @Override
    public void addCoin(CoinDto coinDto) {
        Coin coin = new Coin();
        coin.setId(coinDto.getId());
        coin.setCurrency(coinDto.getCurrency());
        coin.setQuantity(coinDto.getQuantity());

        repository.addCoin(coin);
    }

    @Override
    public void deleteCoin(Integer id) {
        repository.deleteCoin(id);
    }

    @Override
    public void updateCoin(CoinDto coinDto) {
        Coin coin = new Coin();
        coin.setId(coinDto.getId());
        coin.setQuantity(coinDto.getQuantity());
        coin.setCurrency(coinDto.getCurrency());

        repository.updateCoin(coin);
    }
}
