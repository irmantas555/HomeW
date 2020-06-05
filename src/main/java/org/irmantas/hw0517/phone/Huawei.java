package org.irmantas.hw0517.phone;

public class Huawei extends Phone{
    private boolean isKirinChipset;

    public Huawei() {

    }


    public Huawei(boolean isKirinChipset) {
        this.isKirinChipset = isKirinChipset;
    }

    public Huawei(long number, String macAdress, long IMEI, String os, double screenSize, boolean isKirinChipset,String model) {
        super(number, macAdress, IMEI, os, screenSize,model);
        this.isKirinChipset = isKirinChipset;
    }

    public boolean isKirinChipset() {
        return isKirinChipset;
    }
}
