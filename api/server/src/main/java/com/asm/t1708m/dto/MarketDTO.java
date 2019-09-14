package com.asm.t1708m.dto;

import com.asm.t1708m.entity.Market;

import java.util.Calendar;
import java.util.Set;

public class MarketDTO {
    private long id;
    private String name;
    private String description;
    private long createdAT;
    private long updatedAT;
    private long deletedAT;
    private int status;
    private Set<Long> coinID;

    public MarketDTO() {
        this.createdAT = Calendar.getInstance().getTimeInMillis();
        this.updatedAT = Calendar.getInstance().getTimeInMillis();
        this.deletedAT = Calendar.getInstance().getTimeInMillis();
        this.status = 0;
    }

    public MarketDTO(Market market) {
        this.id = market.getId();
        this.name = market.getName();
        this.description = market.getDescription();
        this.createdAT = market.getCreatedAT();
        this.updatedAT = market.getUpdatedAT();
        this.deletedAT = market.getDeletedAT();
//
//        for (int i = 0; i < market.getCoins().size() ; i++) {
//            coinID.add(market.getCoins().iterator().)
//        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(long createdAT) {
        this.createdAT = createdAT;
    }

    public long getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(long updatedAT) {
        this.updatedAT = updatedAT;
    }

    public long getDeletedAT() {
        return deletedAT;
    }

    public void setDeletedAT(long deletedAT) {
        this.deletedAT = deletedAT;
    }

    public Set<Long> getCoinID() {
        return coinID;
    }

    public void setCoinID(Set<Long> coinID) {
        this.coinID = coinID;
    }
    public void setCoinID(long coinID) {
        this.coinID.add(coinID);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
