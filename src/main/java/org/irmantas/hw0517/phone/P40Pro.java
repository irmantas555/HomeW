package org.irmantas.hw0517.phone;

public class P40Pro extends Huawei {
        private boolean IP53 = true;
    String ownersName;

    public P40Pro(boolean IP53) {
        this.IP53 = IP53;
    }

    public P40Pro(boolean isKirinChipset, boolean IP53) {
        super(isKirinChipset);
        this.IP53 = IP53;
    }

    public P40Pro(long number, String macAdress, long IMEI, String os, double screenSize,
                  boolean isKirinChipset, boolean IP53, String model,String ownersName) {
        super(number, macAdress, IMEI, os, screenSize, isKirinChipset,model);
        this.IP53 = IP53;
        this.ownersName = ownersName;
    }

    public boolean isIP53() {
        return IP53;
    }
}
