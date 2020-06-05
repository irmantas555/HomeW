package org.irmantas.hw0517.cars;

public interface Drive {
    void move();
    default void stop() {
        System.out.println("Car fully stopped");
    }
}
