package com.awbp.patterns.decorator;

public interface BankAccount {

    void withdraw(int amount);

    void deposit(int amount);

    int getBalance();
}
