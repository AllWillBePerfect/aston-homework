package com.awbp.patterns.decorator;

public class BasicAccount implements BankAccount {

    private int balance;

    public BasicAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(int amount) {

        if (amount > balance) {
            throw new IllegalStateException("Not enough money");
        }

        balance -= amount;

        System.out.println("Withdrew $" + amount);
    }

    @Override
    public void deposit(int amount) {

        balance += amount;

        System.out.println("Deposited $" + amount);
    }

    @Override
    public int getBalance() {
        return balance;
    }
}