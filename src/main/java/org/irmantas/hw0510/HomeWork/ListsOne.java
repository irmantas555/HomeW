package org.irmantas.collections.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListsOne {
    public static void main(String[] args) {
        List<String> purchases = nextItem();
        choosePurchasesOptions(purchases);

    }

    private static List<String> nextItem() {
        System.out.println("___________________________________");
        System.out.println(" Laba, sudarysime pirkinių sąrašą");
        Scanner scanner = new Scanner(System.in);
        List<String> purchases = new ArrayList<>();
        String item = null;
        while (true) {
            System.out.println("Iveskite pirkinį, 'exit' jei išeiti");
            item = scanner.nextLine();
            if (item.equals("exit")) {
                break;
            } else if (checkItem(item, purchases)) {
                purchases.add(item);
            }
        }
        return purchases;

    }

    public static boolean checkItem(String input, List<String> list) {
        for (String string : list
        ) {
            if (string.equals(input)) {
                return false;
            }
        }
        return true;
    }

    public static void choosePurchasesOptions(List<String> purchases) {
        String option, letter;
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("Dabar galime vykdyti pirkinių paiešką");

        while (true) {
            System.out.println(purchases);
            System.out.println("Pasirinkte raidę, arba 'exit' jei išeiti");
            letter = scanner.nextLine();
            if (letter.isEmpty()) {
                continue;
            } else if (letter.equals("exit")) {
                return;
            }
            System.out.println("Įveskite 1 jei ieškosime to pačio produkto");
            System.out.println("      kurio pirma raidė yra ieškoma");
            System.out.println("Įveskite 2 jei ieškosime produkto už kurio");
            System.out.println("  sekantis produktas prasideda ta raide");
            option = scanner.nextLine();
            if (!(option.equals("1") || option.equals("2"))) {
                continue;
            }
            for (int i = 0; i < purchases.size(); i++) {
                if (purchases.get(i).toLowerCase().charAt(0) == letter.toLowerCase().charAt(0)) {
                    if (i > 0 && option.equals("2")) {
                        System.out.println("Jusų ieškomas produktas: " + purchases.get(i - 1));
                    } else if (option.equals("1")) {
                        System.out.println("Jūsų ieškomas produktas yra: " + purchases.get(i));
                    } else {
                        System.out.println("Tokio produkto nėra");
                    }
                }
            }
        }
    }
}
