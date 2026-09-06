package com.awbp;

import com.awbp.stream.Deadlock;
import com.awbp.stream.Livelock;
import com.awbp.stream.SyncPrint;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Нужно раскомментировать только одну строку для проверки
//        runDeadlock();
//        runLivelock();
//        runSyncPrint();z
    }

    private static void runDeadlock() {
        System.out.println("Sample 1 - Deadlock");
        new Deadlock().sample();
    }

    private static void runLivelock() {
        System.out.println("Sample 2 - Livelock");
        new Livelock().sample();
    }

    private static void runSyncPrint() {
        System.out.println("Sample 3 - SyncPrint");
        new SyncPrint().sample();
    }
}
