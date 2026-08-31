package com.awbp.patterns.stategy;

/** Оплата банковской картой. */
public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " by card");
    }
}
