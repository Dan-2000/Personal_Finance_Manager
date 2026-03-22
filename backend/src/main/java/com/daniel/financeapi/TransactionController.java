package com.daniel.financeapi;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class TransactionController {

    private FinanceManager financeManager = new FinanceManager();
    @GetMapping("/")
    public String home() {
        return "Finance API is running!";
    }
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return financeManager.getTransactions();
    }
    @PostMapping("/transactions")
    public String addTransaction(@RequestBody Transaction transaction) {
        financeManager.addTransaction(transaction);
        return "Transaction added successfully!";
    }
}