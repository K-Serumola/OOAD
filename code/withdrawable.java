public interface withdrawable {
    default void withdraw(double amount, Account account) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining balance: " + account.getBalance());
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}