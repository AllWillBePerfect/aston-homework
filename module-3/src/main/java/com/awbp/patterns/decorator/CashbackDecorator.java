package com.awbp.patterns.decorator;

/** Декоратор с начислением кешбэка. */
public class CashbackDecorator
        extends AccountDecorator {

    public CashbackDecorator(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {

        account.withdraw(amount);

        int cashback = amount / 100;

        account.deposit(cashback);

        System.out.println(
                "Cashback: $" + cashback
        );
    }
}
