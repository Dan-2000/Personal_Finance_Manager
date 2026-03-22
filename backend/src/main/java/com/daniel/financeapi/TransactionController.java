package com.daniel.financeapi;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TransactionController {

    private FinanceService financeService = new FinanceService();
    public TransactionController(){
        this.financeService = financeService;
    }
    @GetMapping("/")
    public String home() {
        return "Finance API is running!";
    }
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return financeService.getTransactions();
    }
    @PostMapping("/transactions")
    public String addTransaction(@RequestBody Transaction transaction) {
        financeService.addTransaction(transaction);
        return "Transaction added successfully!";
    }
    @GetMapping("/summary")
    public void getSummary() {
        financeService.getSummary();
    }
}