package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AccountCreationControler {

    @FXML private TextField InvestmentInitialDeposit;

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
    float initialDepositAmount = Float.parseFloat(InvestmentInitialDeposit.getText());


    //cheque account creation logic
    @FXML
    public void makeChequeAccount(ActionEvent event) throws IOException {
        Cheque newChequeingsAccount = new Cheque(customerID,accountID+1,initialBalance,branch);
    }
    //savings account creation logic
    @FXML
    public void makeSavingsAccount(ActionEvent event) throws IOException {
        Savings newSavingsAccount = new Savings(customerID,accountID+3,initialBalance,branch,0.5f);
    }

    //investment account creation logic
    @FXML
    public void makeInvestmentAccount(ActionEvent event) throws IOException {
        Investments newInvestmentAccount = new Investments(customerID,accountID+2,initialDepositAmount,branch,0.5f);
    }


    //read the name of the method dude
    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("AccountCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
}
