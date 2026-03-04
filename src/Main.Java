import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                     sc.close();
                     return;
                 default:
                     System.out.println(option + " is an invalid option. Please try again.");
             }
         }
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


    //Validation logic for adding transactions - use later when implementing addTransaction method in the main menu
/* while(true) 
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
*/
    }
}