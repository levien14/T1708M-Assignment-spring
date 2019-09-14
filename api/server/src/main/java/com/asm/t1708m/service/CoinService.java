package com.asm.t1708m.service;

import com.asm.t1708m.entity.Coin;

import java.util.List;

public interface CoinService {
    List<Coin> getAll();
    Coin createNewCoin(Coin coin);
    List<Coin> searchByName(String nameCoin);
    List<Coin> searchByMarket(String nameMarket);
}
