public interface interest {

    // Default method charges interest on a given Account
    default void chargeInterest(Account account, float interestRate, double interestAmount) {
        if (interestAmount > 0 && interestRate > 0) {
            double interest = interestRate * interestAmount;
            System.out.println("Charging interest of : " + interest + "% from account : " + account);

            // Update the actual account balance
            account.balance -= interest;

            System.out.println("Balance is now: " + account.getBalance());
        } else {
            System.out.println("Invalid interest amount or rate.");
        }
    }
}