package com.daniel.financeapi;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
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
    public String toCSV() {
        return date + "," + description + "," + amount + "," + type;
    }
    public static Transaction fromCSV(String line){
        if (line.startsWith("date")) {
            return null;
        }
        String[] row = line.split(",");
        String date = row[0];
        String description = row[1];
        double amount = Double.parseDouble(row[2]);
        TransactionType type = TransactionType.valueOf(row[3]);
        return new Transaction(date, description, amount, type);
    }
}