package org.irmantas.hw0517.phone;

public class PrintInSteps implements PrintingSlow {

    @Override
    public void printSlow(int interval, String message) {
                message.chars()
                        .peek(i -> wait(i, 80))
                        .forEach(value -> System.out.print((char) value));
        System.out.println();
    }

    private int wait(int c, int timout) {
        try {
//            System.out.println("Im in wait sequence");
            Thread.sleep(timout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }
}
