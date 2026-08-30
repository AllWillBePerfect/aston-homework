package com.awbp.patterns.adapter;

public class ExternalPaymentSystem {

    public void makeTransaction(double money) {
        System.out.println(
                "External payment: $" + money
        );
    }
}
