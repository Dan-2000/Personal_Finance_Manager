package com.daniel.financeapi.service;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.daniel.financeapi.SummaryResponse;
import com.daniel.financeapi.TransactionRepository;
import com.daniel.financeapi.UserRepository;
import com.daniel.financeapi.model.Transaction;
import com.daniel.financeapi.model.User;

@Service
public class FinanceService {
    private final TransactionRepository repository;
    private final UserRepository userRepository;

    public FinanceService(TransactionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }
    

    public Transaction addTransaction(Transaction transaction) {
     String email = SecurityContextHolder.getContext().getAuthentication().getName();  
     User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found - Please enter a valid email"));
     transaction.setUser(user);
     return repository.save(transaction);
    }
    
    public void deleteTransaction(Long TransactionId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found - Please enter a valid email"));
        Transaction transaction = repository.findById(TransactionId).orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
        if (!transaction.getUser().getUserID().equals(user.getUserID())) {
        throw new IllegalArgumentException("You are not authorised to delete this transaction");
        }
        repository.delete(transaction);
    }
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found - Please enter a valid email"));
        Transaction transaction = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
        if (!transaction.getUser().getUserID().equals(user.getUserID())) {
        throw new IllegalArgumentException("You are not authorised to update this transaction");
        }
        transaction.setDate(updatedTransaction.getDate());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setTransactionType(updatedTransaction.getType());
        transaction.setDescription(updatedTransaction.getDescription());
        return repository.save(transaction);
    }

    public List <Transaction> getTransactions() {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();  
    User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found - Please enter a valid email"));
    return repository.findByUser(user);
  }

    public SummaryResponse getSummary() {
        List<Transaction> transactions = getTransactions();
        double totalIncome = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.INCOME).mapToDouble(Transaction::getAmount).sum();
        double totalExpense = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.EXPENSE).mapToDouble(Transaction::getAmount).sum();
        double netBalance = totalIncome - totalExpense;
        return new SummaryResponse(totalIncome, totalExpense, netBalance);
    }
    
}
