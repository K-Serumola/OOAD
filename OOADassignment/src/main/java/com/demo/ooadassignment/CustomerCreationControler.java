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

public class CustomerCreationControler {

    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private TextField cell;
    @FXML private TextField adress;

    @FXML
    private void CreateProfile(ActionEvent event) throws IOException {
        // Read the values from the text fields
        String n = name.getText();
        String s = surname.getText();
        String p = password.getText();
        String e = email.getText();
        String c = cell.getText();
        String a = adress.getText();

        int idthingy =  Customer.getInstanceCount();
        int CustomerID =0;

        if (idthingy<0){
            CustomerID = idthingy + 1;
        }
        else
            CustomerID = idthingy;

        Customer newCustomer =  new Customer(CustomerID,n,s,p,a,c,e);

        //open the account creation page
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("AccountCreation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
}
