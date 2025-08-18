public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient Funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }
}
