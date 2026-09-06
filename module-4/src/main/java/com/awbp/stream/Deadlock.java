package com.awbp.stream;

public class Deadlock {

    public void sample() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lock1) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " end");

        }, "thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lock2) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "thread2");

        thread1.start();
        thread2.start();

    }



}
