package org.irmantas.hw0517.phone;

public class GalaxyS20Ultra5G extends Samsung{
    private boolean is5g = true;
    String ownersName;

    public GalaxyS20Ultra5G(boolean is5g) {
        this.is5g = is5g;
    }

    public GalaxyS20Ultra5G(boolean isGalaxy, boolean isExynosChipset, boolean is5g) {
        super(isGalaxy, isExynosChipset);
        this.is5g = is5g;
    }

    public GalaxyS20Ultra5G(long number, String macAdress, long IMEI, String os, double screenSize, boolean isGalaxy,
                            boolean isExynosChipset, boolean is5g,String model,String ownersName) {
        super(number, macAdress, IMEI, os, screenSize, isGalaxy, isExynosChipset, model);
        this.is5g = is5g;
        this.ownersName = ownersName;
    }

    public boolean isIs5g() {
        return is5g;
    }
}
