package org.irmantas.hw0510.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTry {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    int input;
        while (true) {
            try {
                System.out.println("Enter integer, enter '101' to exit");
                input = scanner.nextInt();
                if (input == 101) {
                    System.out.println("Bye!");
                    return;
                }
                System.out.println("int -> " + input);

            } catch (InputMismatchException e) {
                System.out.println("Hey! That’s not a value! Try once more.");
                scanner.next();
            }
        }
    }
}
