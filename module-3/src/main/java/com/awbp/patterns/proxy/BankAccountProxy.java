package com.awbp.patterns.proxy;

/** Прокси с проверкой PIN-кода. */
public class BankAccountProxy implements BankAccount {

    private final BankAccount account;
    private final int correctPin;

    public BankAccountProxy(BankAccount account, int correctPin) {
        this.account = account;
        this.correctPin = correctPin;
    }

    private void checkPin(int enteredPin) {

        if (enteredPin != correctPin) {
            throw new IllegalStateException("Invalid PIN");
        }
    }

    @Override
    public void withdraw(int amount, int pin) {

        checkPin(pin);

        account.withdraw(amount, pin);
    }

    @Override
    public void deposit(int amount, int pin) {

        checkPin(pin);

        account.deposit(amount, pin);
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }
}
