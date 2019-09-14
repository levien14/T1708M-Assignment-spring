package com.asm.t1708m.entity;

import com.asm.t1708m.dto.CoinDTO;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String baseAsset;
    private String quoteAsset;
    private int lastPrice;
    private int volumn24h;

    private long createdAt;
    private long updatedAt;
    private long deletedAt;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    public Coin() {
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.deletedAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();

    }

    public Coin(CoinDTO coinDTO) {
        this.name = coinDTO.getName();
        this.baseAsset = coinDTO.getBaseAsset();
        this.quoteAsset = coinDTO.getQuoteAsset();
        this.lastPrice = coinDTO.getLastPrice();
        this.volumn24h = coinDTO.getVolumn24h();
        this.createdAt = coinDTO.getCreatedAt();
        this.updatedAt = coinDTO.getUpdatedAt();
        this.deletedAt = coinDTO.getDeletedAt();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    public int getVolumn24h() {
        return volumn24h;
    }

    public void setVolumn24h(int volumn24h) {
        this.volumn24h = volumn24h;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
