import java.util.Scanner;
public class Transaction {
    private String date;
    private String description;
    private double amount;
    private TransactionType type;

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
        return type.toString();
    }
    public enum TransactionType {
        INCOME, EXPENSE
    }
}