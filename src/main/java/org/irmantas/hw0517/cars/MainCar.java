package org.irmantas.hw0517.cars;


import org.irmantas.hw0517.phone.SlowCosolePirntService;

public class MainCar {
        static  Windows myCarWin;
    public static void main(String[] args) throws InterruptedException {
        CarbioCar myCabrio = new CarbioCar("Vincentas", "Bright red");
        myCarWin = () -> System.out.println("Which window, of which car?");
        myCabrio.move();
        System.out.println("My car color is " + myCabrio.getColor());
        myCabrio.openRoof();
        myCabrio.windiwClose("rear left");
        myCabrio.stop();
        myCabrio.fillPetrol();
        myCabrio.move();
        myCabrio.windowOpen();
        myCabrio.openAllWin();
        myCabrio.closeAllWin();
        openUnknownWindow(myCarWin);

    }

    public static void openUnknownWindow(Windows window) {
     window.windowOpen();
    }

}
