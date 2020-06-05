package org.irmantas.hw0517.computer;

import java.util.Optional;

public class Computer {
    private String name;
    private Processor processor;
    private Keybord keybord;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(String name) {
        this.name = name;
    }

    public Computer(String name, Processor processor, Keybord keybord, Mouse mouse, Monitor monitor) {
        this.name = name;
        this.processor = processor;
        this.keybord = keybord;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Keybord getKeybord() {
        return keybord;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void printKeybordBrand() {
        Optional<String> br = Optional.ofNullable(this.getKeybord().getBrand());
        System.out.println("Our computer keybord brand is " + br.orElse(": Sorry there is no brand"));
    }

    public void printProcesorModel() {
        Optional<String> br = Optional.ofNullable(this.getProcessor().getModel());
        System.out.println("Our computer processor model is " + br.orElse(": Sorry there is no processor model"));
    }

    public void printMonitorSize() {
        double br = this.getMonitor().getScreenSizeInch();
        if (br > 0 ) {
            System.out.println("Our computer monitor size in inch is " + br + "inch");
        } else {
            System.out.println("Sorry there is no monitor size given");
        }
    }
}
