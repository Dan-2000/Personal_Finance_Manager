package com.daniel.financeapi;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Date is required in format YYYY-MM-DD.")
    private String date;

    @NotBlank(message = "Description of transaction is required.")
    private String description;
    
    @Positive(message = "Amount must be positive.")
    private double amount;

    @NotNull(message = "Transaction type is required.")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transaction() {}
    public Transaction(String date, String description, double amount, TransactionType type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }
    public long getID() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public String getDescription(){
        return description;
    }
    public double getAmount() {
        return amount;
    }
    public TransactionType getType() {
        return type;
    }
    public enum TransactionType {
        INCOME, EXPENSE
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
}