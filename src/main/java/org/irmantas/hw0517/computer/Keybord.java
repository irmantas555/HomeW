package org.irmantas.hw0517.computer;

public class Keybord {
    private String brand;
    private String keybordLayout;

    public Keybord() {
    }

    public Keybord(String brand, String keybordLayout) {
        this.brand = brand;
        this.keybordLayout = keybordLayout;
    }

    public String getBrand() {
        return brand;
    }

    public String getKeybordLayout() {
        return keybordLayout;
    }
}
