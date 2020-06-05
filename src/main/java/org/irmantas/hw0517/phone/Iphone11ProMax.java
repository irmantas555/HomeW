package org.irmantas.hw0517.phone;

public class Iphone11ProMax extends Iphone{
    String ownersName;
    private boolean screenOver6Inch = true;


    public Iphone11ProMax(boolean screenOver6Inch) {
        this.screenOver6Inch = screenOver6Inch;
    }

    public Iphone11ProMax(String iOsVersion, boolean retina, boolean screenOver6Inch) {
        super(iOsVersion, retina);
        this.screenOver6Inch = screenOver6Inch;
    }

    public Iphone11ProMax(long number, String macAdress, long IMEI, String os, double screenSize, String iOsVersion,
                          boolean retina, boolean screenOver6Inch,String model,String ownersName) {
        super(number, macAdress, IMEI, os, screenSize, iOsVersion, retina, model);
        this.screenOver6Inch = screenOver6Inch;
        this.ownersName = ownersName;
    }

    public boolean isScreenOver6Inch() {
        return screenOver6Inch;
    }
}
