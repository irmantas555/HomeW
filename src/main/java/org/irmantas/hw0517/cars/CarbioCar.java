package org.irmantas.hw0517.cars;

import org.irmantas.hw0517.phone.PrintInSteps;
import org.irmantas.hw0517.phone.SlowCosolePirntService;


public class CarbioCar implements Petrol,Cabrio, Windows,Drive {
    private String ownerName;
    private String color;
    PrintInSteps print = new PrintInSteps();


    public CarbioCar(String ownerName, String color) {
        this.ownerName = ownerName;
        this.color = color;
    }

    public void openAllWin() throws InterruptedException {
        Windows.allWindowOpen();
    }

    public void closeAllWin() throws InterruptedException {
        Windows.allWindowClose();
    }


    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void openRoof() {
        print.printSlow(100,"My cabrio roof is now fully OPEN");
    }

    @Override
    public void closeRoof() {
        print.printSlow(100,"My cabrio roof is now closed");
    }

    @Override
    public void fillPetrol() {
        print.printSlow(100,"Filling petrol to the max");
    }

    @Override
    public void windowOpen() {
        print.printSlow(100,"The window is open");
    }

    @Override
    public void move() {
        print.printSlow(100,"Now my car is on the run");
    }
}
