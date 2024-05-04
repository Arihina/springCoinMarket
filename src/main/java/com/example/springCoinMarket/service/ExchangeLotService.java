package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.ExchangeLotConverter;
import com.example.springCoinMarket.dao.repository.ExchangeLotRepository;
import com.example.springCoinMarket.dto.ExchangeLotDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ExchangeLotService {
    private final ExchangeLotRepository repository;
    private final CryptocurrencyService cryptoService;
    // TODO division into crypto and fiat
    private final FiatCurrencyService fiatService;

    public HashMap<Long, ExchangeLotDto> getLots() {
        var models = repository.findAll();
        HashMap<Long, ExchangeLotDto> dtoModels = new HashMap<>();

        for (var model : models) {
            // TODO fix 0.
            dtoModels.put(model.getId(), ExchangeLotConverter.toDto(model, 0.));
        }

        return dtoModels;
    }

    public ExchangeLotDto getLot(Long id) {
        var model = repository.getReferenceById(id);
        Double rate = -1.;

        String price = cryptoService.getPrice(model.getCurrencyIn() + model.getCurrencyOut() + "T");

        Pattern pattern = Pattern.compile("\"price\":\"(\\d+\\.\\d+)\"");
        Matcher matcher = pattern.matcher(price);
        if (matcher.find()) {
            rate = Double.parseDouble(matcher.group(1));
        }

        return ExchangeLotConverter.toDto(model, rate);
    }

    public void add(ExchangeLotDto exchangeLotDto) {
        repository.save(ExchangeLotConverter.toModel(exchangeLotDto));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
