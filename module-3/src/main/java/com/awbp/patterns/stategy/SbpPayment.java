package com.awbp.patterns.stategy;

/** Оплата через СБП. */
public class SbpPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " using SBP");
    }
}
