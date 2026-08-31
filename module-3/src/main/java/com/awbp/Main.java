package com.awbp;


import com.awbp.patterns.adapter.ExternalPaymentSystem;
import com.awbp.patterns.adapter.PaymentAdapter;
import com.awbp.patterns.adapter.PaymentGateway;
import com.awbp.patterns.builder.Transfer;
import com.awbp.patterns.chain.BanknoteHandler;
import com.awbp.patterns.decorator.BankAccount;
import com.awbp.patterns.decorator.BasicAccount;
import com.awbp.patterns.decorator.CashbackDecorator;
import com.awbp.patterns.decorator.InsuranceDecorator;
import com.awbp.patterns.proxy.BankAccountProxy;
import com.awbp.patterns.proxy.RealBankAccount;
import com.awbp.patterns.stategy.CardPayment;
import com.awbp.patterns.stategy.CashPayment;
import com.awbp.patterns.stategy.PaymentService;
import com.awbp.patterns.stategy.SbpPayment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        strategySample();
        chainSample();
        builderSample();
        proxySample();
        decoratorSample();
        adapterSample();

    }

    /**
     * Пример Strategy
     */
    public static void strategySample() {
        var paymentService = new PaymentService();

        paymentService.setStrategy(new CardPayment());
        paymentService.pay(100);

        paymentService.setStrategy(new SbpPayment());
        paymentService.pay(200);

        paymentService.setStrategy(new CashPayment());
        paymentService.pay(300);
    }

    /**
     * Пример Chain of Responsibility
     */
    public static void chainSample() {
        var handler50 = new BanknoteHandler(50);
        var handler10 = new BanknoteHandler(10);
        var handler5 = new BanknoteHandler(5);
        var handler1 = new BanknoteHandler(1);
        handler50.setBanknoteHandler(handler10);
        handler10.setBanknoteHandler(handler5);
        handler5.setBanknoteHandler(handler1);
        handler50.process(76);
    }

    /**
     * Пример Builder
     */
    public static void builderSample() {
        var transfer = new Transfer.Builder()
                .from("Alice")
                .to("Bob")
                .amount(1500)
                .currency("USD")
                .purpose("Payment")
                .comment("For services")
                .build();
    }


    /**
     * Пример Proxy
     */
    public static void proxySample() {
        com.awbp.patterns.proxy.BankAccount realAccount =
                new RealBankAccount(1000);
        com.awbp.patterns.proxy.BankAccount account =
                new BankAccountProxy(realAccount, 1234);
        account.withdraw(300, 1234);
        account.deposit(500, 1234);
        System.out.println(
                "Balance: $" + account.getBalance()
        );
        account.withdraw(100, 1111);
    }


    /**
     * Пример Decorator
     */
    public static void decoratorSample() {
        BankAccount account =
                new BasicAccount(1000);
        account =
                new CashbackDecorator(account);
        account =
                new InsuranceDecorator(account);
        account.withdraw(500);
        System.out.println(
                "Balance: $" + account.getBalance()
        );
    }

    /**
     * Пример Adapter
     */
    public static void adapterSample() {
        var externalSystem =
                new ExternalPaymentSystem();

        PaymentGateway paymentGateway =
                new PaymentAdapter(externalSystem);

        paymentGateway.pay(100);
    }


}