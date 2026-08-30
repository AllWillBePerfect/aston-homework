package com.awbp.patterns.proxy;

public interface BankAccount {

    void withdraw(int amount, int pin);

    void deposit(int amount, int pin);

    int getBalance();
}
