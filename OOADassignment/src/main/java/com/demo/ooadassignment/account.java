package com.demo.ooadassignment;

public abstract class Account {
    //atributes
    int accountno;
    double balance;
    String branch;

    //constructor
    public Account(Customer customer, int accountno, double balance, String branch) {
        customer.customerID = customer.getCustomerID();
        this.accountno = accountno;
        this.balance = balance;
        this.branch = branch;
    }

    //getters
    public int getAccountno() {
        return accountno;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }


    //methods
    public void deposit(double ammount) {
        if (ammount > 0) {
            balance += ammount;
            System.out.println("Deposited: " + ammount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

}
