package com.example.springCoinMarket.converter;

import com.example.springCoinMarket.dao.model.ExchangeLot;
import com.example.springCoinMarket.dto.ExchangeLotDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExchangeLotConverter {
    public ExchangeLot toModel(ExchangeLotDto exchangeLotDto) {
        var model = new ExchangeLot();
        model.setId(exchangeLotDto.getId());
        model.setCurrencyIn(exchangeLotDto.getCurrencyIn());
        model.setCurrencyOut(exchangeLotDto.getCurrencyOut());

        return model;
    }

    public ExchangeLotDto toDto(ExchangeLot exchangeLot, Double rate)
    {
        return ExchangeLotDto.builder().
                id(exchangeLot.getId()).
                rate(rate).
                currencyIn(exchangeLot.getCurrencyIn()).
                currencyOut(exchangeLot.getCurrencyOut()).
                build();
    }
}
