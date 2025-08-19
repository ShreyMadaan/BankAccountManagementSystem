public interface AccountRepository {
    void save(IAccount account);
    IAccount findByNumber(int accountNumber);
}
