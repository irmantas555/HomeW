package org.irmantas.hw0517.computer;

public class Mouse {
    private Technology technology;
    private boolean wireless;

    public Mouse() {
    }

    public Mouse(Technology technology, boolean wireless) {
        this.technology = technology;
        this.wireless = wireless;
    }

    public Technology getTechnology() {
        return technology;
    }

    public boolean isWireless() {
        return wireless;
    }
}
