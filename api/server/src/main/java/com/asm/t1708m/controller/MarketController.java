package com.asm.t1708m.controller;

import com.asm.t1708m.dto.MarketDTO;
import com.asm.t1708m.entity.Coin;
import com.asm.t1708m.entity.Market;
import com.asm.t1708m.rest.RESTResponse;
import com.asm.t1708m.service.CoinServiceImp;
import com.asm.t1708m.service.MarketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/market")
public class MarketController {

    @Autowired
    private MarketServiceImp marketServiceImp;
    @Autowired
    private CoinServiceImp coinServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        List<Market> markets = marketServiceImp.getAll();
        if (markets == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        ArrayList<MarketDTO> marketDTOS = new ArrayList<>();
        for (Market market:markets
             ) {
            MarketDTO marketDTO = new MarketDTO(market);
            for (Coin coin:market.getCoins()
                 ) {
                marketDTO.setCoinID(coin.getId());
            }
            marketDTOS.add(marketDTO);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(1)
                .setMessage("List Market.")
                .setData(marketDTOS)
                .build(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody MarketDTO marketDTO){
        Market market = new Market(marketDTO);
        marketServiceImp.createNew(market);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(1)
                .setMessage("Add new Success.")
                .setData(marketDTO)
                .build(),HttpStatus.CREATED);
    }
}
