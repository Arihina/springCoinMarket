package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.CoinDao;
import com.example.springCoinMarket.dao.repository.CoinMemoryRepository;
import com.example.springCoinMarket.dto.CoinDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class CoinServiceMemory implements CoinService {
    private final CoinMemoryRepository repository;

    public CoinServiceMemory() {
        repository = new CoinMemoryRepository();
    }

    @Override
    public HashMap<Integer, CoinDto> getCoins() {
        HashMap<Integer, CoinDto> coinsDto = new HashMap<>();
        HashMap<Integer, CoinDao> coinsDao = repository.getCoins();

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
    public CoinDto getCoin(int id) {
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
        CoinDao coinDao = new CoinDao();
        coinDao.setId(coinDto.getId());
        coinDao.setCurrency(coinDto.getCurrency());
        coinDao.setQuantity(coinDto.getQuantity());

        repository.addCoin(coinDao);
    }
}
