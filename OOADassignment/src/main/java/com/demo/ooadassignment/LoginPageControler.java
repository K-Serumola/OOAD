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

public class LoginPageControler {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label error;

    private int cusid;


    @FXML
    public void loginbutton(ActionEvent event) throws IOException {
        String enteredUser = username.getText();
        String enteredPass = password.getText();

        cusid = Customer.findCustomer(enteredUser, enteredPass);

        if (cusid != 0) {
            // Load next page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();

            // ✅ Get HomePage controller and pass customer ID
            HomePageControler homeController = loader.getController();
            homeController.setCustomerID(cusid);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            error.setText("Invalid username or password!");
        }
    }
}
