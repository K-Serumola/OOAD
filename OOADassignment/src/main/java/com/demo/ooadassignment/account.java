package com.demo.ooadassignment;

import java.util.ArrayList;
import java.util.List;

public class Account {

    // Attributes
    private static List<Account> allAccounts = new ArrayList<>();

    private Customer customer;
    private int accountno;
    double balance;
    private String branch;

    // Constructor
    public Account(Customer customer, int accountno, double balance, String branch) {
        this.customer = customer;
        this.accountno = accountno;
        this.balance = balance;
        this.branch = branch;

    }

    // Getters
    public int getAccountno() {
        return accountno;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


    public static List<Account> getAccountsByCustomerID(int cusid) {
        List<Account> result = new ArrayList<>();
        for (Account acc : allAccounts) {
            if (acc.getCustomer().getCustomerID() == cusid) {
                result.add(acc);
            }
        }
        return result; // can be empty if none found
    }


}

