package com.awbp.patterns.chain;

/** Обработчик выдачи банкнот одного номинала. */
public class BanknoteHandler {

    private int denomination;
    private BanknoteHandler next;

    public BanknoteHandler(int denomination) {
        this.denomination = denomination;
    }


    public void process(int amount) {
        int count = amount / denomination;

        if (count > 0) {
            System.out.println(
                    "Withdrawing " + count + " " + denomination + "$ banknotes"
            );
        }

        if (next != null) {
            next.process(amount % denomination);
        }
    }

    public void setBanknoteHandler(BanknoteHandler banknoteHandler) {
        this.next = banknoteHandler;
    }



}
