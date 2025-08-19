public class BankAccount implements IAccount {
    private static int accountCounter = 1000; // Auto-generate account numbers

    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin; // Secure access

    public BankAccount(String accountHolderName, String pin, double balance) {
        this.accountNumber = ++accountCounter;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            return false; // Insufficient funds
        }
        balance -= amount;
        return true;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
