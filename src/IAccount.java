public interface IAccount {
    int getAccountNumber();
    String getAccountHolderName();
    double getBalance();
    void deposit(double amount);
    /**
     * Attempts to withdraw the specified amount.
     * @param amount amount to withdraw; must be > 0 and <= balance
     * @return true if successful; false if insufficient funds
     * @throws IllegalArgumentException if amount is not positive
     */
    boolean withdraw(double amount);
    boolean verifyPin(String pin);
}
