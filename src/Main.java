import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApplication {
    private static Map<Integer, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount loggedInAccount = null;

    public static void main(String[] args) {
        while (true) {
            if (loggedInAccount == null) {
                showMainMenu();
            } else {
                showAccountMenu();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n--- Welcome to Bank Application ---");
        System.out.println("1. Create a New Account");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> createAccount();
            case 2 -> login();
            case 0 -> {
                System.out.println("Goodbye 👋");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice, try again!");
        }
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Set a 4-digit PIN: ");
        String pin = scanner.next();
        System.out.print("Enter initial deposit: ");
        double balance = scanner.nextDouble();

        BankAccount newAccount = new BankAccount(name, pin, balance);
        accounts.put(newAccount.getAccountNumber(), newAccount);

        System.out.println("✅ Account created successfully!");
        System.out.println("Your Account Number is: " + newAccount.getAccountNumber());
    }

    private static void login() {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        BankAccount account = accounts.get(accNo);

        if (account != null && account.verifyPin(pin)) {
            loggedInAccount = account;
            System.out.println("✅ Login successful! Welcome " + account.getAccountHolderName());
        } else {
            System.out.println("❌ Invalid account number or PIN!");
        }
    }

    private static void showAccountMenu() {
        System.out.println("\n--- Account Menu (" + loggedInAccount.getAccountHolderName() + ") ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println("💰 Balance: " + loggedInAccount.getBalance());
            case 2 -> {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                loggedInAccount.deposit(amount);
                System.out.println("✅ Deposit successful! New Balance: " + loggedInAccount.getBalance());
            }
            case 3 -> {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                loggedInAccount.withdraw(amount);
                System.out.println("✅ Withdrawal successful! New Balance: " + loggedInAccount.getBalance());
            }
            case 4 -> {
                loggedInAccount = null;
                System.out.println("👋 Logged out successfully!");
            }
            default -> System.out.println("Invalid choice!");
        }
    }
}
