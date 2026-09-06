package com.awbp.stream;

public class Livelock {

    static class Person {
        private final String name;
        private boolean wantsToPass = true;

        public Person(String name) {
            this.name = name;
        }

        public boolean wantsToPass() {
            return wantsToPass;
        }

        public void pass() {
            wantsToPass = false;
        }

        public void stepAside() {
            System.out.println(name + ": отхожу в сторону");
        }
    }

    public void sample() {

        Person person1 = new Person("Человек 1");
        Person person2 = new Person("Человек 2");

        Thread thread1 = new Thread(() -> {
            while (person1.wantsToPass()) {
                if (person2.wantsToPass()) {
                    System.out.println("Человек 1: вижу, что Человек 2 хочет пройти");
                    person1.stepAside();
                } else {
                    System.out.println("Человек 1: прохожу");
                    person1.pass();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (person2.wantsToPass()) {
                if (person1.wantsToPass()) {
                    System.out.println("Человек 2: вижу, что Человек 1 хочет пройти");
                    person2.stepAside();
                } else {
                    System.out.println("Человек 2: прохожу");
                    person2.pass();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
