package org.irmantas.hw0517.computer;

public class Processor {
    private String brand;
    private String model;

    public Processor() {
    }

    public Processor(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
