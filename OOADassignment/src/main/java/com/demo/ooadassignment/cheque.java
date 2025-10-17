package com.demo.ooadassignment;

public class Cheque extends Account implements Withdraw {

    //const
    public Cheque(Customer customerID, int accountNo, double balance, String branch){
        super(customerID,accountNo,balance,branch);    //calls super class constructor
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
}
