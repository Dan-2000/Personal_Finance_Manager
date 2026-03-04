import java.util.Scanner;
public Scanner sc = new Scanner(System.in);
public class main {
    public static void main(String[] args) {
       System.out.println("Personal Finance Manager
       /n 1. Add Transaction
       /n 2. View All Transactions
       /n 3. View Summary 
       /n 4. Exit
       /n Please select an option:");
         int option = new sc.nextInt();
         switch (option) {
       case 1:
           // Code to add transaction
           menu();
           break;
       case 2:
           // Code to view all transactions
           menu();
           break;
       case 3:
           // Code to view summary
           menu();
           break;
       case 4:
           System.out.println("Exiting Personal Finance Manager. Goodbye!");
           break;
       default:
           System.out.println(option + " is an invalid option. Please try again.");
        }
    }   
}