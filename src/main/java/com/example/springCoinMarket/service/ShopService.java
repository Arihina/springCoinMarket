package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.ShopConverter;
import com.example.springCoinMarket.dao.repository.ShopRepository;
import com.example.springCoinMarket.dto.CashDto;
import com.example.springCoinMarket.dto.ShopDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository repository;

    @Transactional(readOnly = true)
    public HashMap<Long, ShopDto> getShops()
    {
        var shops = repository.findAll();
        HashMap<Long, ShopDto> shopsDto = new HashMap<>();

        for (var model : shops) {
            shopsDto.put(model.getId(), ShopConverter.toDto(model));
        }

        return shopsDto;
    }

    @Transactional(readOnly = true)
    public ShopDto getShop(Long id)
    {
        var model = repository.getReferenceById(id);
        return ShopConverter.toDto(model);
    }

    @Transactional
    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    @Transactional
    public void add(ShopDto shopDto)
    {
        repository.save(ShopConverter.toModel(shopDto));
    }

    @Transactional
    public void replenish(CashDto cashDto, Long id) {
        var model = repository.findById(id);
        model.get().setQuantity(cashDto.getCountCoin());
    }
}
