package com.asm.t1708m.entity;

import com.asm.t1708m.dto.MarketDTO;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private long createdAT;
    private long updatedAT;
    private long deletedAT;
    private int status;

    @OneToMany(mappedBy = "market",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Coin> coins;

    public Market() {

        if (this.coins == null){
            this.coins = new HashSet<>();
        }

        this.createdAT = Calendar.getInstance().getTimeInMillis();
        this.updatedAT = Calendar.getInstance().getTimeInMillis();
        this.deletedAT = Calendar.getInstance().getTimeInMillis();
        this.status = 0;
    }

    public Market(MarketDTO marketDTO) {
        this.name = marketDTO.getName();
        this.description = marketDTO.getDescription();
        this.createdAT = marketDTO.getCreatedAT();
        this.updatedAT = marketDTO.getUpdatedAT();
        this.deletedAT = marketDTO.getDeletedAT();
        this.status = marketDTO.getStatus();
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

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }

    public void setCoins(Coin coins){
        if (this.coins == null){
            this.coins = new HashSet<>();
        }
        this.coins.add(coins);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
