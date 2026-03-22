package com.daniel.financeapi;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class FinanceService {
    private final TransactionRepository repository;
    public FinanceService(TransactionRepository repository) {
        this.repository = repository;
    }
    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }
    public List <Transaction> getTransactions() {
        return repository.findAll();
    }
    
}
