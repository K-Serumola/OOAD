package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ChequePageControler {
    @FXML private Label accountno;
    @FXML private Label balance;
    @FXML private TextField depoamount;
    @FXML private TextField withdrawammount;

    private Account acc; // make acc a field so we can reuse it

    @FXML
    void initialize() {
        int cusid = HomePageControler.getLiveCustomerID();

        acc = Account.getAccountsByCustomerID(cusid)
                .stream()
                .filter(a -> a instanceof Cheque)
                .findFirst()
                .orElse(null);

        if (acc != null) {
            accountno.setText(String.valueOf(acc.getAccountno()));
            balance.setText(String.valueOf(acc.getBalance()));
        } else {
            accountno.setText("N/A");
            balance.setText("No Cheque Account Found");
        }
    }

    @FXML
    void deposit(ActionEvent event) {
        if (acc == null) {
            System.out.println("No account found!");
            return;
        }

        try {
            double amount = Double.parseDouble(depoamount.getText());
            acc.deposit(amount); // ✅ deposit into this account
            balance.setText(String.valueOf(acc.getBalance())); // ✅ update balance display
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered!");
        }
    }

    @FXML
    void withdraw(ActionEvent event) {
        if (acc == null) {
            System.out.println("No account found!");
            return;
        }

        try {
            double amount = Double.parseDouble(withdrawammount.getText());
            ((Cheque) acc).withdraw(amount); // ✅ call withdraw on the actual Cheque account
            balance.setText(String.valueOf(acc.getBalance())); // ✅ update balance
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered!");
        }
    }
}
