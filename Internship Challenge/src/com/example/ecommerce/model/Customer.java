package com.example.ecommerce.model;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double debitAmount) {
        balance -= debitAmount;
    }
}
