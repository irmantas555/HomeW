package org.irmantas.hw0517.cars;

public interface Windows {
    void windowOpen();
    default void windiwClose(String window) {
        System.out.println("Window " + window + " is closed");
    }
    static void oneWindowOpen(String window) {
        System.out.println("Window " + window + " is opened");
    }

    static void allWindowClose() throws InterruptedException {
        System.out.println("All windows closing...");
        Thread.sleep(1000);
        System.out.println("All closed");
    }
    static void allWindowOpen() throws InterruptedException {
        System.out.println("All windows opening...");
        Thread.sleep(1000);
        System.out.println("All opened");
    }

}
