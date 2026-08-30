package com.awbp.patterns.decorator;

public abstract class AccountDecorator
        implements BankAccount {

    protected final BankAccount account;

    protected AccountDecorator(BankAccount account) {
        this.account = account;
    }

    @Override
    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    @Override
    public void deposit(int amount) {
        account.deposit(amount);
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }
}