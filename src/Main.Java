import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FinanceManager financeManager = new FinanceManager();
         while (true) {
             System.out.printf("Personal Finance Manager"+
       "%n 1. Add Transaction" +
       "%n 2. View All Transactions" +
       "%n 3. View Summary" +
       "%n 4. Exit" +
       "%n Please select an option:");
            int option = sc.nextInt();
             switch (option) {
                 case 1:
                     System.out.println("Please enter the transaction details:");
                     System.out.println("Date (YYYY-MM-DD):");
                     String date = sc.next();
                     System.out.println("Please enter a Description:");
                     String description = sc.next();
                     System.out.println("Please enter an amount:");
                     double amount = sc.nextDouble();
                     System.out.println("Please select the transaction type (1 for Income, 2 for Expense):");
                     int typeOption = sc.nextInt();
                     Transaction.TransactionType type;
                     if (typeOption == 1) {
                        type = Transaction.TransactionType.INCOME;
                     }
                    else {
                        type = Transaction.TransactionType.EXPENSE;
                        }
                    validateTransactionAdd(date, description, amount, typeOption);
                     System.out.println("Transaction added: " + date + " - " + description + " - $" + amount + " - " + type);
                     financeManager.addTransaction(new Transaction(date,description, amount, type));
                     break;
                 case 2:
                    List<Transaction> transactions = financeManager.getTransactions();
                    if (transactions.isEmpty()) {
                        system.out.println("No transactions found.");
                    } else {
                        for (Transaction i : transactions) {
                            System.out.println(i.getDate() + " - " +
                                               i.getDescription() + " - $" + 
                                               i.getAmount() + " - " + 
                                               i.getType());
                        }
                    })
                        
                 break;
                 case 3:
                     // Code to view summary
                     system.out.println("Summary feature is under development. Please check back later.");
                     break;
                 case 4:
                     System.out.println("Exiting Personal Finance Manager. Goodbye!");
                     return;
                 default:
                     System.out.println(option + " is an invalid option. Please try again.");
                }
        }
    sc.close();
    }
     
    //Validation logic for adding transactions
    public static validateTransactionAdd(String date, String description, double amount, int typeOption) {
     while(true) 
            {
            if (!isValidDate(date)) 
            {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format:");
                date = sc.next();
            } 
            else if (description.isEmpty()) 
            {
                System.out.println("Description cannot be empty. Please enter a valid description:");
                description = sc.nextLine();
            }
            else if (amount <= 0) 
            {
                System.out.println("Amount must be greater than zero. Please enter a valid amount:");
                amount = sc.nextDouble();
            }
            else if (typeOption != 1 && typeOption != 2) 
            {
                System.out.println("Invalid transaction type. Please select 1 for Income or 2 for Expense:");
                typeOption = sc.nextInt();
            }
            else 
            { 
                break;
                }
            }

        }
    }
