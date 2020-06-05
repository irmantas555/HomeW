package org.irmantas.hw0517.ioN.car;

import java.util.Scanner;

public class bandom {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String s;
        while (true) {
            System.out.println("Ivesk teksto eilute");
            s = scanner.next();
            if (s.equals("exit")) {
                return;
            }
            System.out.println("pirmas zenklas: " + s.substring(0,1));
        }
    }
}
