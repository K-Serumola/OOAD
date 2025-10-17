package com.demo.ooadassignment;

public interface Interest {

    default void chargeInterest( float interestRate, double interestAmount) {}
}
