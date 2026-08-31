package com.awbp.patterns.adapter;

/** Адаптер внешней платёжной системы. */
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
