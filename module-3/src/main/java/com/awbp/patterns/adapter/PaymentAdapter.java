package com.awbp.patterns.adapter;


public class PaymentAdapter implements PaymentGateway {

    private final ExternalPaymentSystem externalSystem;

    public PaymentAdapter(
            ExternalPaymentSystem externalSystem
    ) {
        this.externalSystem = externalSystem;
    }

    @Override
    public void pay(int amount) {

        externalSystem.makeTransaction(amount);
    }
}