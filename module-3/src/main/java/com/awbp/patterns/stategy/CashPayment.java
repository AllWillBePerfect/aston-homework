package com.awbp.patterns.stategy;

/** Оплата наличными. */
public class CashPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " in cash");
    }
}
