package com.daniel.financeapi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
}
