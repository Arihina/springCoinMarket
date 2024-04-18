package com.example.springCoinMarket.service;

import com.example.springCoinMarket.converter.CoinWalletConverter;
import com.example.springCoinMarket.dao.model.Wallet;
import com.example.springCoinMarket.dao.repository.CoinRepository;
import com.example.springCoinMarket.dao.repository.CoinWalletRepository;
import com.example.springCoinMarket.dao.repository.WalletRepository;
import com.example.springCoinMarket.dto.CoinWalletDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Primary
public class CoinWalletServiceDb implements CoinWalletService {
    private final CoinWalletRepository repository;
    private final WalletRepository walletRepository;
    private final CoinRepository coinRepository;

    @Override
    public HashMap<Long, CoinWalletDto> getCoinWallets() {
        var coinWallets = repository.findAll();
        HashMap<Long, CoinWalletDto> coinWalletsDto = new HashMap<>();

        for (var coinWallet : coinWallets) {
            var modelDto = CoinWalletConverter.toDto(coinWallet);
            coinWalletsDto.put(modelDto.getId(), modelDto);
        }

        return coinWalletsDto;
    }

    @Override
    public CoinWalletDto getCoinWallet(Long id) {
        return CoinWalletConverter.toDto(repository.getReferenceById(id));
    }

    @Override
    public void addCoinWallet(CoinWalletDto coinWalletDto, Long id) {
        var wallet = walletRepository.findById(id).get();
        var coin = coinRepository.findById(coinWalletDto.getCoinId()).get();
        var coinWalletModel = CoinWalletConverter.toModel(coinWalletDto);

        coinWalletModel.setWallet(wallet);
        coinWalletModel.setCoin(coin);
        wallet.getCoinWallets().add(coinWalletModel);
        coin.getCoinWallets().add(coinWalletModel);

        repository.save(coinWalletModel);
    }

    @Override
    public void deleteCoinWallet(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCoinWallet(CoinWalletDto coinWalletDto) {
        repository.save(CoinWalletConverter.toModel(coinWalletDto));
    }
}
