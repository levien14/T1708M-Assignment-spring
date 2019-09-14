package com.asm.t1708m.service;

import com.asm.t1708m.entity.Market;
import com.asm.t1708m.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImp implements MarketService {

    @Autowired
    private MarketRepository marketRepository;

    @Override
    public List<Market> getAll() {
        return marketRepository.findAll();
    }

    @Override
    public Market createNew(Market market) {
        marketRepository.save(market);
        return market;
    }

    @Override
    public Market findById(long id) {
        Market market = marketRepository.findById(id).orElse(null);
        return market;
    }
}
