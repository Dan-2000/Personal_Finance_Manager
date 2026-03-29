package com.daniel.financeapi.model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
@Entity
public class Transaction {
    // Data types & validation rules
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TransactionId;

// database connection
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

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
    //getters
    public long getID() {
        return TransactionId;
    }
    public User getUser() {
        return user;
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
    //setters
    public void setUser(User user) {
        this.user = user;
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
    public void setTransactionType(TransactionType type) {
        this.type = type;
    }
}