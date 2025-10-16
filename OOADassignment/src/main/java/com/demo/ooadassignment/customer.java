package com.demo.ooadassignment;

public class customer{
    //atributes
    String name;
    String surname;
    String adress;
    int cell;
    String email;

    // constructor
    public customer(String name, String surname, String adress, int cell, String email){
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.cell = cell;
        this.email = email;
    }

    // getters
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getAdress(){
        return adress;
    }
    public int getCell(){
        return cell;
    }
    public String getEmail(){
        return email;
    }
}
