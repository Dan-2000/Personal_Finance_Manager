package com.daniel.financeapi;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TransactionController {

    private final FinanceService financeService;
    public TransactionController(FinanceService financeService){
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
    public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
        System.out.println("Added transaction: " + transaction.getDescription());
        financeService.addTransaction(transaction);
        return transaction;
    }
}