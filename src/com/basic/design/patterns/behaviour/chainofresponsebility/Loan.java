package com.basic.design.patterns.behaviour.chainofresponsebility;

public class Loan {
    double amount;
    public Loan(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
