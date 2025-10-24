package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InvestmentPageControler {

    @FXML private Label accountno;
    @FXML private Label balance;
    @FXML private Label interestrate;
    @FXML private TextField depoamount;
    @FXML private TextField withdrawamount;

    private Account acc; // store the user's investment account

    @FXML
    void initialize() {
        int cusid = HomePageControler.getLiveCustomerID();

        acc = Account.getAccountsByCustomerID(cusid)
                .stream()
                .filter(a -> a instanceof Investments) // 🔍 filter for Investment accounts
                .findFirst()
                .orElse(null);


        if (acc != null) {
            accountno.setText(String.valueOf(acc.getAccountno()));
            balance.setText(String.valueOf(acc.getBalance()));
            interestrate.setText("0.5");
        } else {
            accountno.setText("N/A");
            balance.setText("No Investment Account Found");
        }
    }

    @FXML
    void deposit(ActionEvent event) {
        if (acc == null) {
            System.out.println("No Investment account found!");
            return;
        }

        try {
            double amount = Double.parseDouble(depoamount.getText());
            acc.deposit(amount);
            balance.setText(String.valueOf(acc.getBalance())); // update balance
        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount!");
        }
    }

    @FXML
    void withdraw(ActionEvent event) {
        if (acc == null) {
            System.out.println("No Investment account found!");
            return;
        }

        try {
            double amount = Double.parseDouble(withdrawamount.getText());
            ((Investments) acc).withdraw(amount);
            balance.setText(String.valueOf(acc.getBalance()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

