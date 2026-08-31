package com.awbp.patterns.adapter;

/** Внешняя платёжная система. */
public class ExternalPaymentSystem {

    public void makeTransaction(double money) {
        System.out.println(
                "External payment: $" + money
        );
    }
}
