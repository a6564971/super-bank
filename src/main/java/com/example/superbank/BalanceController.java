package com.example.superbank;
import com.example.superbank.model.TransferBalance;
import org.springframework.web.bind.annotation.*;

@RestController("/ballance")

public class BalanceController {

    private final BankService bankService;

    public BalanceController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{accountId}")

    public Integer getBallance(@PathVariable Long accountId){

        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")

    public Integer addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(),transferBalance.getAmount());
    }
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){

        bankService.makeTransfer(transferBalance);
    }


}
