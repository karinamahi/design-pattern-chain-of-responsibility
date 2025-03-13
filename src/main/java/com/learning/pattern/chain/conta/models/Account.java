package com.learning.pattern.chain.conta.models;

public class Account {

    private String owner;
    private double balance;
    
    public Account(String owner, double balance) {
	super();
	this.owner = owner;
	this.balance = balance;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public double getBalance() {
        return balance;
    }
    public void setValue(double value) {
        this.balance = value;
    }
}
