package com.awbp.stream;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    private void operation1() {
        while (true) {
            try {
                lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("lock1 acquired, trying to acquire lock2.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock2.tryLock()) {
                System.out.println("lock2 acquired");
            } else {
                System.out.println("cannot acquire lock2, releasing lock1");
                lock1.unlock();
                continue;
            }

            System.out.println("executing first operation");
            break;

        }
        lock2.unlock();
        lock1.unlock();
    }

    private void operation2() {
        while (true) {
            try {
                lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("lock2 acquired, trying to acquire lock1.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock1.tryLock()) {
                System.out.println("lock1 acquired");
            } else {
                System.out.println("cannot acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }

            System.out.println("executing first operation");
            break;

        }
        lock1.unlock();
        lock2.unlock();
    }

    public void sample() {
        new Thread(this::operation1, "T1").start();
        new Thread(this::operation2, "T2").start();
    }
}
