package com.example.springCoinMarket.service;

import com.example.springCoinMarket.dao.model.TradingPair;
import com.example.springCoinMarket.dao.repository.TradingPairsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class TradingPairsService {
    private TradingPairsRepository repository;

    @Transactional(readOnly = true)
    public HashMap<Integer, TradingPair> getTradingPairs()
    {
        var tradingPairs = repository.findAll();
        HashMap<Integer, TradingPair> pairs = new HashMap<>();

        for (var pair : tradingPairs)
            pairs.put(pair.getId(), pair);

        return pairs;
    }

    @Transactional(readOnly = true)
    public TradingPair getTradingPair(Integer id)
    {
        return repository.getReferenceById(id);
    }

    @Transactional
    public void deleteTradingPair(Integer id)
    {
        repository.deleteById(id);
    }

    @Transactional
    public void createTradingPair(TradingPair pairs)
    {
        repository.save(pairs);
    }
}
