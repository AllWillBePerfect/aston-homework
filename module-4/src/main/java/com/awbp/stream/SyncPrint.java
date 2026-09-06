package com.awbp.stream;

public class SyncPrint {
    private final Object lock = new Object();
    private boolean isFirst = true;

    public void sample() {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isFirst) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    System.out.println("1");
                    isFirst = false;
                    lock.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isFirst) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    System.out.println("2");
                    isFirst = true;
                    lock.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
    }

}