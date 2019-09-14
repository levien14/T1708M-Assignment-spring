package com.asm.t1708m.service;

import com.asm.t1708m.entity.Coin;
import com.asm.t1708m.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceImp implements CoinService {

    @Autowired
    private CoinRepository coinRepository;
    @Override
    public List<Coin> getAll() {
        return coinRepository.findAll();
    }

    @Override
    public Coin createNewCoin(Coin coin) {
        coinRepository.save(coin);
        return coin;
    }

    @Override
    public List<Coin> searchByName(String nameCoin) {
        return coinRepository.findAllByName(nameCoin);
    }

    @Override
    public List<Coin> searchByMarket(String nameMarket) {
        return coinRepository.findAllByName(nameMarket);
    }

}
