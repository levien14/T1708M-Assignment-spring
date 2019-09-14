package com.asm.t1708m.dto;

import com.asm.t1708m.entity.Coin;

public class CoinDTO {
    private long id;
    private String name;
    private String baseAsset;
    private String quoteAsset;
    private int lastPrice;
    private int volumn24h;
    private long marketid;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;

    public CoinDTO() {
    }

    public CoinDTO(Coin coin) {
        this.id = coin.getId();
        this.name = coin.getName();
        this.baseAsset = coin.getBaseAsset();
        this.quoteAsset = coin.getQuoteAsset();
        this.lastPrice = coin.getLastPrice();
        this.volumn24h = coin.getVolumn24h();
        this.marketid = coin.getMarket().getId();
        this.createdAt = coin.getCreatedAt();
        this.updatedAt = coin.getUpdatedAt();
        this.deletedAt  = coin.getDeletedAt();
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

    public long getMarketid() {
        return marketid;
    }

    public void setMarketid(long marketid) {
        this.marketid = marketid;
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
}
