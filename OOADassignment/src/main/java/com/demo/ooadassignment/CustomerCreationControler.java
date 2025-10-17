package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerCreationControler {

    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private TextField cell;
    @FXML private TextField adress;

    @FXML
    private void CreateProfile(ActionEvent event) {
        // Read the values from the text fields
        String n = name.getText();
        String s = surname.getText();
        String p = password.getText();
        String e = email.getText();
        String c = cell.getText();
        String a = adress.getText();

        int idthingy =  Customer.getInstanceCount();
        int CustomerID = idthingy+1;

        Customer newCustomer =  new Customer(CustomerID,n,s,p,a,c,e);
    }
}
