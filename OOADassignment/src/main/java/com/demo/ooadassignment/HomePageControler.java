package com.demo.ooadassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HomePageControler {

    @FXML private Label cusname;
    private static int liveCustomerID;  // holds the value passed from login page

    // ✅ This method is called from the login controller
    public static void setCustomerID(int id) {
        liveCustomerID = id;
    }

    public static int getLiveCustomerID() {
        return liveCustomerID;
    }

    public void openCheckings(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("ChequePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }

    public void openSavings(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("SavingsPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }

    public void openInvestments(ActionEvent event) throws IOException {
        Parent aboutRoot = FXMLLoader.load(getClass().getResource("InvestmentPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(aboutRoot));
        stage.show();
    }
}
