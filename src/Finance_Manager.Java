import java.util.List;
import java.util.ArrayList;
public class Finance_Manager {
  private List<Transaction> transactions;

    public void addTransaction(List transactions, String date, String description, double amount){
        Transaction transactions = new Transaction(date, description, amount);
        transactions.add(transactions);
    } 
    public void viewAllTransactions(List transactions) {
        return transactions;
    }     
  } 
