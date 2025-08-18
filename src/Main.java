import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null; // declare outside loop

        while (true) {
            printMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter Account Holder Name: ");
                    sc.nextLine(); // consume leftover newline
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    String accNumber = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    account = new BankAccount(name, accNumber, balance);
                    System.out.println("Account created successfully!");
                    break;

                case 2: // Deposit
                    if (account == null) {
                        System.out.println("No account exists. Please create one first.");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;

                case 3: // Withdraw
                    if (account == null) {
                        System.out.println("No account exists. Please create one first.");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 4: // Check Balance
                    if (account == null) {
                        System.out.println("No account exists. Please create one first.");
                    } else {
                        System.out.println("Current Balance: " + account.getBalance());
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting the application. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n----- Bank Application -----");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
