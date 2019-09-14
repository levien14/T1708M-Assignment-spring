package com.asm.t1708m.service;


import com.asm.t1708m.entity.Market;

import java.util.List;

public interface MarketService {
    List<Market> getAll();
    Market createNew(Market market);
    Market findById(long id);
}
