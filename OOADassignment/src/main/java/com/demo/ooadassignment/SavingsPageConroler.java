package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SavingsPageConroler {

    @FXML private Label accountno;
    @FXML private Label balance;
    @FXML private TextField depoamount;
    @FXML private TextField withdrawamount;
    @FXML private TextField interest;

    private Account acc; // store this customer's Savings account


    @FXML
    void initialize() {
        int cusid = HomePageControler.getLiveCustomerID();

        acc = Account.getAccountsByCustomerID(cusid)
                .stream()
                .filter(a -> a instanceof Savings) // filter for Savings accounts
                .findFirst()
                .orElse(null);

        if (acc != null) {
            accountno.setText(String.valueOf(acc.getAccountno()));
            balance.setText(String.valueOf(acc.getBalance()));
            interest.setText("0.005%");
        } else {
            accountno.setText("N/A");
            balance.setText("No Savings Account Found");
        }
    }

    @FXML
    void deposit(ActionEvent event) {
        if (acc == null) {
            System.out.println("No Savings account found!");
            return;
        }

        try {
            double amount = Double.parseDouble(depoamount.getText());
            acc.deposit(amount);
            balance.setText(String.valueOf(acc.getBalance())); // update the balance label
        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount!");
        }
    }
}
