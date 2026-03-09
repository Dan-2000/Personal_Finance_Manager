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
  }
