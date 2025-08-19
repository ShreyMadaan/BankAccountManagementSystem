public class AccountService {
    private final AccountRepository repository;
    private final AccountFactory factory;

    public AccountService(AccountRepository repository, AccountFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public IAccount createAccount(String name, String pin, double initialDeposit) {
        IAccount acc = factory.create(name, pin, initialDeposit);
        repository.save(acc);
        return acc;
    }

    public IAccount login(int accountNumber, String pin) {
        IAccount acc = repository.findByNumber(accountNumber);
        if (acc != null && acc.verifyPin(pin)) {
            return acc;
        }
        return null;
    }

    public double getBalance(IAccount account) {
        return account.getBalance();
    }

    public void deposit(IAccount account, double amount) {
        account.deposit(amount);
        repository.save(account); // ensure persisted state
    }

    public boolean withdraw(IAccount account, double amount) {
        boolean ok = account.withdraw(amount);
        if (ok) {
            repository.save(account);
        }
        return ok;
    }
}
