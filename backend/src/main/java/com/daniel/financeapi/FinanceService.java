package com.daniel.financeapi;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class FinanceService {
    private final TransactionRepository repository;
    public FinanceService(TransactionRepository repository) {
        this.repository = repository;
    }
    public void addTransaction(Transaction transaction) {
        System.out.println("Saving to DB...");
        repository.save(transaction);
    }
    public List <Transaction> getTransactions() {
        return repository.findAll();
    }
    
}
