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
    public SummaryResponse getSummary() {
        List<Transaction> transactions = repository.findAll();
        double totalIncome = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.INCOME).mapToDouble(Transaction::getAmount).sum();
        double totalExpense = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.EXPENSE).mapToDouble(Transaction::getAmount).sum();
        double netBalance = totalIncome - totalExpense;
        return new SummaryResponse(totalIncome, totalExpense, netBalance);
    }
    
}
