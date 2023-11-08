package com.example.superbank;

import com.example.superbank.model.TransferBalance;

import org.springframework.stereotype.Service;

@Service

public class BankService {

    private final BalanceRepository repository;

    public BankService(BalanceRepository repository) {
        this.repository = repository;
    }

    public Integer getBalance(Long accountId) {
        Integer balance = repository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public Integer addMoney(Long to, Integer amount) {
        Integer currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {
            repository.save(to, amount);
            return amount;
        } else {
            Integer updateBalance = currentBalance + amount;
            repository.save(to, updateBalance);
            return updateBalance;
        }
    }

    public void makeTransfer(TransferBalance transferBalance) {
        Integer fromBalance = repository.getBalanceForId(transferBalance.getFrom());
        Integer toBalance = repository.getBalanceForId(transferBalance.getTo());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("no ids");
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        Integer updatedFromBalance = fromBalance - (transferBalance.getAmount());
        Integer updatedToBalance = toBalance + (transferBalance.getAmount());
        repository.save(transferBalance.getFrom(), updatedFromBalance);
        repository.save(transferBalance.getTo(), updatedToBalance);
    }
}







