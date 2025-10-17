package com.demo.ooadassignment;

public class Customer {
    //atributes

    static int instanceCount = 0;
    int customerID;
    String name;
    String password;
    String surname;
    String adress;
    String cell;
    String email;

    // constructor
    public Customer( int customerID, String name, String surname, String password, String adress, String cell, String email){
        this.customerID = customerID;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.cell = cell;
        this.email = email;
    }

    // getters
    public int getCustomerID(){return customerID;}
    public String getPassword() {return password;}
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getAdress(){
        return adress;
    }
    public String getCell(){
        return cell;
    }
    public String getEmail(){
        return email;
    }
    public static int getInstanceCount() {return instanceCount;}
}
