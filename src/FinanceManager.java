import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
public class FinanceManager {
private List<Transaction> transactions;
private String filePath= "data/Transactions.csv";
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
public void saveTransaction(Transaction transaction) {
    // Implement file saving logic here (e.g., using FileWriter or CSV libraries)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
      for (Transaction t: transactions){
        writer.write(transaction.getDate() + "," + transaction.getDescription() + "," + transaction.getAmount() + "," + transaction.getType());
        writer.newLine();
      }
        
    } catch (Exception e) {
      e.printStackTrace();
    }

}
public void loadTransactions() throws IOException {
    // Implement file loading logic here (e.g., using BufferedReader or CSV libraries)
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      while((line = reader.readLine()) !=null){
        String[] row = line.split(",");
        for(String index: row) {
          String date = row[0];
          String description = row[1];
          double amount = Double.parseDouble(row[2]);
          Transaction.TransactionType type = Transaction.TransactionType.ValueOf(row[3]);
          transactions.add(new Transaction(date, description, amount, type));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
