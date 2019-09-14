package com.asm.t1708m.repository;

import com.asm.t1708m.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin,Long> {
    List<Coin> findAllByName(String nameCoin);

}
