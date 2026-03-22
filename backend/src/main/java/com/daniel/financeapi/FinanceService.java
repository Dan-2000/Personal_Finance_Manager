package com.daniel.financeapi;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class FinanceService {
    private FinanceManager financeManager = new FinanceManager();
    public void addTransaction(Transaction transaction) {
        financeManager.addTransaction(transaction);
    }
    public List <Transaction> getTransactions() {
        return financeManager.getTransactions();    
    }

    public void getSummary() {
        financeManager.getSummary();
    }
    
}
