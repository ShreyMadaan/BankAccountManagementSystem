import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Depend on abstractions (DIP)
    private static final AccountRepository accountRepository = new InMemoryAccountRepository();
    private static final AccountFactory accountFactory = new AccountFactory();
    private static final AccountService accountService = new AccountService(accountRepository, accountFactory);

    private static IAccount loggedInAccount = null;

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

        try {
            IAccount newAccount = accountService.createAccount(name, pin, balance);
            System.out.println("✅ Account created successfully!");
            System.out.println("Your Account Number is: " + newAccount.getAccountNumber());
        } catch (IllegalArgumentException ex) {
            System.out.println("❌ " + ex.getMessage());
        }
    }

    private static void login() {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        IAccount account = accountService.login(accNo, pin);

        if (account != null) {
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
            case 1 -> System.out.println("💰 Balance: " + accountService.getBalance(loggedInAccount));
            case 2 -> {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                try {
                    accountService.deposit(loggedInAccount, amount);
                    System.out.println("✅ Deposit successful! New Balance: " + accountService.getBalance(loggedInAccount));
                } catch (IllegalArgumentException ex) {
                    System.out.println("❌ " + ex.getMessage());
                }
            }
            case 3 -> {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                try {
                    boolean ok = accountService.withdraw(loggedInAccount, amount);
                    if (ok) {
                        System.out.println("✅ Withdrawal successful! New Balance: " + accountService.getBalance(loggedInAccount));
                    } else {
                        System.out.println("❌ Insufficient Funds");
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("❌ " + ex.getMessage());
                }
            }
            case 4 -> {
                loggedInAccount = null;
                System.out.println("👋 Logged out successfully!");
            }
            default -> System.out.println("Invalid choice!");
        }
    }
}
