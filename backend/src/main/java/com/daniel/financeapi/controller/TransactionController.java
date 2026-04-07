package com.daniel.financeapi.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.financeapi.SummaryResponse;
import com.daniel.financeapi.model.Transaction;
import com.daniel.financeapi.service.FinanceService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "https://personalfinancemanagerfrontend-production.up.railway.app")
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
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.ok(financeService.getTransactions());
    }
    @PostMapping("/transactions")
    public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction savedTransaction = financeService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        financeService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
        Transaction updatedTransaction = financeService.updateTransaction(id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }
    @GetMapping("/summary")
    public ResponseEntity<SummaryResponse> getSummary() {
        return ResponseEntity.ok(financeService.getSummary());
    }
}