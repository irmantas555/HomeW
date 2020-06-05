package org.irmantas.hw0517.computer;

public class MainComputer {
    public static void main(String[] args) {
        Monitor monitor1 = new Monitor("Acer", 32, "LSD");
        Mouse mouse1 = new Mouse(Technology.OPTICAL, true);
        Keybord keybord1 = new Keybord("Genius", "EN-US");
        Processor processor1 = new Processor("Intel", "i5-9600K");
        Computer computer1 = new Computer("i5 mon:Acer Kb:GEnius", processor1, keybord1, mouse1, monitor1);
        computer1.printKeybordBrand();
        computer1.printProcesorModel();
        computer1.printMonitorSize();
        Monitor monitor2 = new Monitor();
        Mouse mouse2 = new Mouse();
        Processor processor2 = new Processor();
        Keybord keybord2 = new Keybord();
        Computer computer2 = new Computer("i5 mon:Acer Kb:GEnius", processor2, keybord2, mouse2, monitor2);
        computer2.printKeybordBrand();
        computer2.printProcesorModel();
        computer2.printMonitorSize();
    }



}
