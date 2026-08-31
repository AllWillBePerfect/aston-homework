package com.awbp.patterns.decorator;

/** Декоратор страхования операций. */
public class InsuranceDecorator
        extends AccountDecorator {

    public InsuranceDecorator(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {

        System.out.println(
                "Insurance check..."
        );

        account.withdraw(amount);

        System.out.println(
                "Transaction is insured"
        );
    }


}
