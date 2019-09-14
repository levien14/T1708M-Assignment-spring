package com.asm.t1708m.controller;

import com.asm.t1708m.dto.CoinDTO;
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
@RequestMapping(value = "/api/v1/coin")
public class CoinController {

    @Autowired
    private CoinServiceImp coinServiceImp;
    @Autowired
    private MarketServiceImp marketServiceImp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        List<Coin> coins = coinServiceImp.getAll();
        if (coins == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        ArrayList<CoinDTO> coinDTOS = new ArrayList<>();
        for (Coin coin:coins
             ) {
            CoinDTO coinDTO = new CoinDTO(coin);
            coinDTOS.add(coinDTO);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(1)
                .setMessage("List Coin .")
                .setData(coinDTOS)
                .build(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addNewCoin(@RequestBody CoinDTO coinDTO){
        Coin coin = new Coin(coinDTO);
        Market market = marketServiceImp.findById(coinDTO.getMarketid());
        if (market == null){
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setStatus(0)
                    .setMessage("Not Found Market Id")
                    .build(),HttpStatus.NOT_FOUND);
        }
        coin.setMarket(market);
        coinServiceImp.createNewCoin(coin);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(1)
                .setMessage("Add new Success")
                .setData(coinDTO)
                .build(),HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/{coinName}")
    public ResponseEntity<Object> findByName(@PathVariable String coinName){
        List<Coin> coins = coinServiceImp.searchByName(coinName);
        if (coins == null){
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setStatus(0)
                    .setMessage("Not Found")
                    .build(),HttpStatus.NOT_FOUND);
        }
        ArrayList<CoinDTO> coinDTOS = new ArrayList<>();
        for (Coin coin:coins
        ) {
            CoinDTO coinDTO = new CoinDTO(coin);
            coinDTOS.add(coinDTO);
        }

        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(1)
                .setMessage("List coin by name" + coinName + " .")
                .setData(coinDTOS)
                .build(), HttpStatus.OK);
    }
}
