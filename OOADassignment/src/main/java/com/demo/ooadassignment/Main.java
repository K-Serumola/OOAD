package com.demo.ooadassignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    // Make lists static so controllers can access them
    private static List<Customer> customers;
    private static List<Account> accounts;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load all data from DB at startup
        customers = CustomerDAO.getAllCustomers();
        accounts = AccountDAO.getAllAccounts();

        // data check
        System.out.println("Loaded " + customers.size() + " customers and " + accounts.size() + " accounts.");

        // Load FXML
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));

        // Create and set up scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("My JavaFX Bank App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Access methods for controllers
    public static List<Customer> getCustomers() { return customers; }
    public static List<Account> getAccounts() { return accounts; }
}
