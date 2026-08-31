package com.awbp.patterns.proxy;

/** Реальный банковский счёт. */
public class RealBankAccount implements BankAccount {

    private int balance;

    public RealBankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(int amount, int pin) {

        if (amount > balance) {
            throw new IllegalStateException("Not enough money");
        }

        balance -= amount;

        System.out.println("Withdrew $" + amount);
    }

    @Override
    public void deposit(int amount, int pin) {

        balance += amount;

        System.out.println("Deposited $" + amount);
    }

    @Override
    public int getBalance() {
        return balance;
    }

}
