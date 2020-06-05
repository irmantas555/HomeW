package org.irmantas.hw0517.phone;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public static void sleep(int interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
