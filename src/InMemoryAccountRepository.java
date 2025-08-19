import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<Integer, IAccount> storage = new HashMap<>();

    @Override
    public void save(IAccount account) {
        storage.put(account.getAccountNumber(), account);
    }

    @Override
    public IAccount findByNumber(int accountNumber) {
        return storage.get(accountNumber);
    }
}
