public class BankAccount {
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

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
