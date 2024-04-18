package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.CoinConverter;
import com.example.springCoinMarket.dao.repository.CoinRepository;
import com.example.springCoinMarket.dto.CoinDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class CoinServiceDb implements CoinService {
    private final CoinRepository repository;
    @Override
    @Transactional(readOnly = true)
    public HashMap<Long, CoinDto> getCoins() {
        var coins = repository.findAll();
        HashMap<Long, CoinDto> coinsDto = new HashMap<>();

        for (var coin : coins) {
            var modelDto = CoinConverter.toDto(coin);
            coinsDto.put(modelDto.getId(), modelDto);
        }

        return coinsDto;
    }

    @Override
    @Transactional(readOnly = true)
    public CoinDto getCoin(Long id) {
        return CoinConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    @Transactional
    public void addCoin(CoinDto coinDto) {
        repository.save(CoinConverter.toModel(coinDto));
    }

    @Override
    @Transactional
    public void deleteCoin(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCoin(CoinDto coinDto) {
        repository.save(CoinConverter.toModel(coinDto));
    }
}
