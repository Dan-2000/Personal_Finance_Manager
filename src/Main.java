import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FinanceManager financeManager = new FinanceManager();
        financeManager.loadTransactions(); 
         while (true) {
             System.out.printf("Personal Finance Manager"+
       "%n 1. Add Transaction" +
       "%n 2. View All Transactions" +
       "%n 3. View Summary" +
       "%n 4. Exit" +
       "%n Please select an option:");
            int option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    String date = getValidDate(sc);
                    String description = getValidDescription(sc);
                    double amount = getValidAmount(sc);
                    Transaction.TransactionType type = getValidTypeOption(sc);
                    financeManager.addTransaction(new Transaction(date, description, amount, type));
                    System.out.println("Transaction added: " + date + " - " + description + " - $" + amount + " - " + type);
                }
                case 2 -> {
                    List<Transaction> transactions = financeManager.getTransactions();
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction t : transactions) {
                            System.out.println(t.getDate() + " - " +
                                               t.getDescription() + " - $" + 
                                               t.getAmount() + " - " + 
                                               t.getType());
                        }
                    }
                }
                case 3 -> financeManager.getSummary();
                case 4 -> {
                    System.out.println("Exiting Personal Finance Manager. Goodbye!");
                    return;
                }
                default -> System.out.println(option + " is an invalid option. Please try again.");
            }
    }
}
     
    //Validation logic for adding transactions

    public static String getValidDate(Scanner sc) {
        while(true){
            System.out.println("Please enter the transaction date (YYYY-MM-DD):");
            String date = sc.next();
            if (!isValidDate(date)) 
            {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format:");
                date = sc.next();
                return date;
            } 
            else 
            {
                return date;
            }
        }
    }

    public static String getValidDescription(Scanner sc) {
        while(true){
            System.out.println("Please enter a description for the transaction:");
            String description = sc.next();
            if (description.isEmpty()) 
            {
                System.out.println("Description cannot be empty. Please enter a valid description:");
                description = sc.next();
                return description;
            } 
            else 
            {
                return description;
            }
        }
    }
    public static double getValidAmount(Scanner sc) {
        while(true) {
            System.out.println("Please enter the transaction amount:");
            double amount = sc.nextDouble();
            if (amount <= 0) 
            {
                System.out.println("Amount must be greater than zero. Please enter a valid amount:");
                amount = sc.nextDouble();
                return amount;
            }
            else 
            {
                return amount;
            }
        }
    }
    public static Transaction.TransactionType getValidTypeOption(Scanner sc){
        while(true){
            System.out.println("Please select the transaction type (1 for Income, 2 for Expense):");
            int typeOption = sc.nextInt();
            switch (typeOption) {
                case 1 ->{
                     return Transaction.TransactionType.INCOME;
                }
                case 2 ->{
                     return Transaction.TransactionType.EXPENSE;
                }
            
            default -> System.out.println(typeOption + " is an invalid transaction type. Please select 1 for Income or 2 for Expense:");
    }   
 }
}
    public static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}
