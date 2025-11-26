package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AccountCreationControler {

    @FXML private TextField InvestmentInitialDeposit;
    @FXML private Label InvestmentMessage;
    @FXML private Label CheckMessage;
    @FXML private Label savingsmessage;

    //open respective account creation pages
    @FXML
    public void makeCheckings(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("ChequeCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
    @FXML
    public void makeInvestment(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("InvestmentCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
    @FXML
    public void makeSavings(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("SavingsCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
    //just gets stuff for constructors
    int idthingy = Customer.getInstanceCount();
    Customer customerID = Customer.getLiveCustomer(idthingy);
    int accountID = 0;
    float initialBalance = 0.0f;
    String branch = "North";

    private int nextAccountID() {
        return ++accountID;
    }



    //cheque account creation logic
    @FXML
    public void makeChequeAccount(ActionEvent event) throws IOException {
        Cheque newChequeingsAccount = new Cheque(customerID,nextAccountID(),initialBalance,branch);
        CheckMessage.setText("Account Created");
    }
    //savings account creation logic
    @FXML
    public void makeSavingsAccount(ActionEvent event) throws IOException {
        Savings newSavingsAccount = new Savings(customerID,nextAccountID(),initialBalance,branch,0.5f);
        savingsmessage.setText("Account Created");
    }

    //investment account creation logic
    @FXML
    public void makeInvestmentAccount(ActionEvent event) throws IOException {
        float initialDepositAmount = 0f;
        try {
            initialDepositAmount = Float.parseFloat(InvestmentInitialDeposit.getText());
        } catch (NumberFormatException e) {
            initialDepositAmount = 0f;
        }

        Investments newInvestmentAccount =
                new Investments(customerID,nextAccountID(),initialDepositAmount,branch,5.0f);
        InvestmentMessage.setText("Account Created");
    }


    //read the name of the method dude
    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("AccountCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }

    @FXML
    public void backtologin(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
}
