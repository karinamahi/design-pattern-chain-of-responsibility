package com.learning.pattern.chain.conta.models;

public class Account {

    private String titular;
    private double saldo;
    
    public Account(String titular, double saldo) {
	super();
	this.titular = titular;
	this.saldo = saldo;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setValue(double value) {
        this.saldo = value;
    }
}
