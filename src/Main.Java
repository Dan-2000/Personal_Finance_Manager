import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       System.out.printf("Personal Finance Manager"+
       "%n 1. Add Transaction" +
       "%n 2. View All Transactions" +
       "%n 3. View Summary" +
       "%n 4. Exit" +
       "%n Please select an option:");
         int option = sc.nextInt();
         switch (option) {
       case 1:
           // Code to add transaction
           
           break;
       case 2:
           // Code to view all transactions
           break;
       case 3:
           // Code to view summary     
           break;
       case 4:
           System.out.println("Exiting Personal Finance Manager. Goodbye!");
           break;
       default:
           System.out.println(option + " is an invalid option. Please try again.");
        }
        sc.close();
    }   
}