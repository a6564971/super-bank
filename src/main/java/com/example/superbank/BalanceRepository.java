package com.example.superbank;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {

    private final Map<Long, Integer> storage = new HashMap<>(Map.of(1L,10));

    public Integer getBalanceForId(Long accountId) {

        return storage.get(accountId);
    }


    public void save(Long id, Integer amount){
        storage.put(id, amount);
    }
}
