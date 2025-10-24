package com.demo.ooadassignment;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //atributes
    static int instanceCount = 0;
    private static List<Customer> allCustomers = new ArrayList<>();

    int customerID;
    String name;
    String password;
    String surname;
    String adress;
    String cell;
    String email;

    // constructor
    public Customer(int customerID, String name, String surname, String password, String adress, String cell, String email) {
        this.customerID = customerID;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.cell = cell;
        this.email = email;

        allCustomers.add(this);
    }

    // getters
    public int getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getCell() {
        return cell;
    }

    public String getEmail() {
        return email;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    //find user using username and password
    public static int findCustomer(String name, String password) {
        for (Customer c : allCustomers) {
            if (c.getName().equals(name) && c.getPassword().equals(password)) {
                return c.getCustomerID(); // match found
            }
        }
        return 0; // no match
    }

    public static Customer getLiveCustomer(int customerID) {
        for (Customer c : allCustomers) {
            if (c.getCustomerID() == customerID) {
                return c;
            }

        }
        return null;
    }
}

