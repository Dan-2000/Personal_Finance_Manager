package com.daniel.financeapi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FinanceManager {
private List<Transaction> transactions;
private static final String filePath= "data/Transactions.csv";
  public FinanceManager() {
    transactions = new ArrayList<>();
    try {
      loadTransactions();
    } catch (IOException e) {
      System.out.println("Error loading transactions: ");
    }
  }

    public void addTransaction(Transaction transaction) {
      try {
        transactions.add(transaction);
        saveTransaction(transaction);
      } catch (IOException e) {
        System.out.println("Error saving transaction: ");
      }
    }
    public List <Transaction> getTransactions() {
        return transactions;
    }
    public void getSummary() {
      double income = 0;
      double expenses = 0;
      for (Transaction t: transactions){
        if(t.getType() == Transaction.TransactionType.INCOME){
          income += t.getAmount();
        } 
        else if (t.getType() == Transaction.TransactionType.EXPENSE) {
          expenses += t.getAmount();
        }
        }
        System.out.println("Total Income: $" + income);
        System.out.println("Total Expenses: $" + expenses);
        System.out.println("Net Balance: $" + (income - expenses));
    }     
public void saveTransaction(Transaction transaction) throws IOException {
    // Implement file saving logic here (e.g., using FileWriter or CSV libraries)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
        writer.write(transaction.toCSV());
        writer.newLine();
      }
        
     
    catch (Exception e) {
      e.printStackTrace();
    }

}
public void loadTransactions() throws IOException {
    // Implement file loading logic here (e.g., using BufferedReader or CSV libraries)
    transactions.clear();
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      while((line = reader.readLine()) !=null){
        Transaction transaction = Transaction.fromCSV(line);
        if (transaction !=null) {
          transactions.add(transaction);
        }
    } 
  }
    catch (IOException e) {
      System.out.println("No existing transactions file found.");
    }
  }
}
