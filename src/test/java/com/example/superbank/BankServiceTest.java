package com.example.superbank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);

    @Test
    void getBalance() {
       Integer balance = bankService.getBalance(1L);
       assertEquals(balance, 10);
    }

    @Test
    void addMoney() {
        Integer balance = bankService.addMoney(1L, 1);
        assertEquals(balance, 11);
    }
}