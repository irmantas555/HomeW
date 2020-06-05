package org.irmantas.hw0517.computer;

public class Monitor {
    private String brand;
    private double screenSizeInch;
    private String technology;

    public Monitor() {
    }

    public Monitor(String brand, double screenSizeInch, String technology) {
        this.brand = brand;
        this.screenSizeInch = screenSizeInch;
        this.technology = technology;
    }

    public String getBrand() {
        return brand;
    }

    public double getScreenSizeInch() {
        return screenSizeInch;
    }

    public String getTechnology() {
        return technology;
    }
}
