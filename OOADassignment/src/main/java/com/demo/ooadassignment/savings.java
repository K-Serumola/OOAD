package com.demo.ooadassignment;

public class savings extends account implements interest {
    float interesRate;

    public savings(int accountNo,double balance, String branch, float interesRate) {
        super(accountNo,balance,branch);
        this.interesRate=interesRate;
    }
}
