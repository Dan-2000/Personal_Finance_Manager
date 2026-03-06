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
    public void getSummary() {
      double income = 0;
      double expenses = 0;
      for (Transaction t: transactions){
        if(t.Type == Transaction.TransactionType.INCOME){
          income += t.getAmount();
        } 
        else if (t.Type == Transaction.TransactionType.EXPENSE) {
          expenses += t.getAmount();
        }
        }
    }     
  }
