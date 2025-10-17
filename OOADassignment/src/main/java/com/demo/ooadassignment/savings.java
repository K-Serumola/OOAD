package com.demo.ooadassignment;

public class Savings extends Account implements Interest {
    float interesRate;

    public Savings(Customer customerID, int accountNo, double balance, String branch, float interesRate) {
        super(customerID,accountNo,balance,branch);
        this.interesRate=interesRate;
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
