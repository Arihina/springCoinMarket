package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.CoinConverter;
import com.example.springCoinMarket.dao.model.Coin;
import com.example.springCoinMarket.dao.repository.CoinMemoryRepository;
import com.example.springCoinMarket.dto.CoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoinServiceMemory implements CoinService {
    private final CoinMemoryRepository repository;

    @Autowired
    public CoinServiceMemory(CoinMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public HashMap<Long, CoinDto> getCoins() {
        HashMap<Long, CoinDto> coinsDto = new HashMap<>();
        Map<Long, Coin> coinsDao = repository.getCoins();

        for (var key : coinsDao.keySet()) {
            CoinDto modelDto = CoinConverter.toDto(coinsDao.get(key));
            coinsDto.put(key, modelDto);
        }

        return coinsDto;
    }

    @Override
    public CoinDto getCoin(Long id) {
        return CoinConverter.toDto(repository.getCoin(id));
    }

    @Override
    public void addCoin(CoinDto coinDto) {
        repository.addCoin(CoinConverter.toModel(coinDto));
    }

    @Override
    public void deleteCoin(Long id) {
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
