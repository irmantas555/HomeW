package org.irmantas.hw0510.concurrency;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        sayHello();
        new Thread(new TestOne()).start();

        TestOne object1 = new TestOne();
        TestOne object2 = new TestOne();
        new Thread(object1).start();
        new Thread(object2).start();


        TestOne objectValue2 = new TestOne(6);
        new Thread(objectValue2).start();

        TestOne objectValue4 = new TestOne(5);
        Thread sleepy = new Thread(objectValue4);
        sleepy.setName("sleep");
        sleepy.start();

    }

    private static void sayHello() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).start();
    }

}

class TestOne implements Runnable {
    private int someValue = 0;

    public TestOne() {
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }

    public TestOne(int someValue) {
        this.someValue = someValue;
    }

    @Override
    public void run() {
        if (someValue > 0) {
            System.out.println("Hello: " + someValue);
        } else {
        System.out.println("I run runnable class from thread: " + Thread.currentThread().getName());
        }
        if (Thread.currentThread().getName().equals("sleep")) {
            boolean proceed = true;
            Scanner scanner =  new Scanner(System.in);
            while (proceed) {
                System.out.println("Hello: " + someValue);
                System.out.println("Ivęsk nauja reikšmę kintamajam");
                System.out.println("Norint išeiti spausk 0");
                someValue = scanner.nextInt();
                if (someValue == 0) {
                    proceed = false;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
