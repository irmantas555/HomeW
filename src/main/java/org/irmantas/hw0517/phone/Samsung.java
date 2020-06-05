package org.irmantas.hw0517.phone;

public class Samsung extends Phone{
    private boolean isGalaxy;
    private boolean isExynosChipset;

    public Samsung() {

    }

    public Samsung(boolean isGalaxy, boolean isExynosChipset) {
        this.isGalaxy = isGalaxy;
        this.isExynosChipset = isExynosChipset;
    }

    public Samsung(long number, String macAdress, long IMEI, String os, double screenSize, boolean isGalaxy, boolean isExynosChipset,String model) {
        super(number, macAdress, IMEI, os, screenSize, model);
        this.isGalaxy = isGalaxy;
        this.isExynosChipset = isExynosChipset;
    }

    public boolean isGalaxy() {
        return isGalaxy;
    }

    public boolean isExynosChipset() {
        return isExynosChipset;
    }
}
