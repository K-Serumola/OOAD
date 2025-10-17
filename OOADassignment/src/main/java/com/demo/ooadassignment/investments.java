package com.demo.ooadassignment;

public class Investments extends Account implements Withdraw, Interest {
    float interesRate;

    public Investments(Customer customerID, int accountNo, double balance, String branch, float interesRate) {
        super(customerID,accountNo,balance,branch);
        this.interesRate=interesRate;
    }

    @Override
    public void withdraw(double amount) {
        Withdraw.super.withdraw(amount);

        if (amount > 0 && amount <= this.getBalance()) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining balance: " + this.getBalance());
        } else if (amount > this.getBalance()) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    @Override
    public void chargeInterest(float interestRate, double interestAmount) {
        Interest.super.chargeInterest(interestRate, interestAmount);
        this.interesRate+=interestRate;

        if (interestAmount > 0 && interestRate > 0) {
            double interest = interestRate * interestAmount;
            //System.out.println("Charging interest of : " + interest + "% from account : " + account);

            // Update the actual account balance
            this.balance -= interest;

            // System.out.println("Balance is now: " + account.getBalance());
        } else {
            System.out.println("Invalid interest amount or rate.");
        }
    }
}
