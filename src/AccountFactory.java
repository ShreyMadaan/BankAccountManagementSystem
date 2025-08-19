public class AccountFactory {
    public IAccount create(String name, String pin, double initialDeposit) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (pin == null || pin.length() != 4 || !pin.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("PIN must be a 4-digit number");
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        return new BankAccount(name, pin, initialDeposit);
    }
}
