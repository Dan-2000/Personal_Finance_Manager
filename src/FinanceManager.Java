import java.util.List;
import java.util.ArrayList;
public class FinanceManager {
  private List<Transaction> transactions;
  public FinanceManager() {
    transactions = new ArrayList<>();
  }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    } 
    public List <Transaction> getTransactions() {
        return transactions;
    }     
  }
