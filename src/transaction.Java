import java.util.Scanner;
public Scanner sc = new Scanner(System.in);
public class transaction {
    public static void main(String[] args) {

    }
     public void addTransaction(String date, String description, double amount) {
        System.out.println("Please enter the transaction date (YYYY-MM-DD):");
        date = sc.nextLine();
        System.out.println("Please enter the transaction description:");
        description = sc.nextLine();
        System.out.println("Please enter the transaction amount:");
        amount = sc.nextDouble();
        while(true) 
            {
            if (!isValidDate(date)) 
            {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format:");
                date = sc.nextLine();
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
            else 
            { 
                break;
            }
        }
        System.out.println("Transaction added: " + date + " - " + description + " - $" + amount);
    }
}