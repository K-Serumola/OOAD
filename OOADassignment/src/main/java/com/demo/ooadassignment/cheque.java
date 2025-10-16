package com.demo.ooadassignment;

public class cheque extends account implements withdrawable{

    //const
    public cheque(int accountNo,double balance, String branch){
        super(accountNo,balance,branch);    //calls super class constructor
    }


}
