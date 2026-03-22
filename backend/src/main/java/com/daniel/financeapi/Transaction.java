package com.daniel.financeapi;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String description;
    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transaction() {}
    public Transaction(String date, String description, double amount, TransactionType type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
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
}