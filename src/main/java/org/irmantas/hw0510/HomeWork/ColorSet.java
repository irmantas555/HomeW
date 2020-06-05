package org.irmantas.collections.HomeWork;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ColorSet {
    static Scanner scanner = new Scanner(System.in);
    static Set<String> colors = new HashSet<>();
    static {
        colors.add("Raudona");
        colors.add("Geltona");
        colors.add("Balta");
        colors.add("Ruda");
        colors.add("Juoda");
        colors.add("Mėlyna");
        colors.add("Violetinė");
    }

    public static void main(String[] args) {
        Set<String> spalvos = enterColors();
        colorsOptions(spalvos);
    }

    private static void colorsOptions(Set<String> spalvos) {
        AtomicInteger n = new AtomicInteger();
        char optinChoosen;

        while (true) {
            System.out.println("**************************");
            System.out.println("Pasirinkite ka dayrsite su");
            System.out.println("    spalvų sąrašu");
            System.out.println("1 - išmesti");
            System.out.println("2 - rušiuoti");
            System.out.println("3 - išeiti");
            optinChoosen = scanner.nextLine().charAt(0);
            switch (optinChoosen) {
                case '1':
                    ismestiSpalva(spalvos);
                    continue;
                case '2':
                    rusiuotiSpalvas(spalvos);
                    continue;
                case '3':
                    return;
                default:
                    System.out.println("Tokio pasisrinkimo nėra");
            }

        }

    }

    private static void ismestiSpalva(Set<String> spalvos) {
        int i = 1, b;
        String opt, def, removable;
        Iterator<String> stringIterator = spalvos.iterator();
        Map<Integer, String> splavosMapped = new HashMap<>();
        while (stringIterator.hasNext()) {
            def = stringIterator.next();
            splavosMapped.put(i, def);
            System.out.println((i++) + " - " + def);
        }
        while (true) {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("Pasirinkite kuria spalvą išmesite");
            System.out.println("arba 'exit' jei norite išeiti");
            opt = scanner.nextLine();
            if (opt.equals("exit")) {
                break;
            }
            b = Integer.parseInt(opt);
            removable = splavosMapped.get(b);
            spalvos.remove(removable);
            printColors();
            System.out.println("Spalva: " + removable + " išmesta");
        }


    }


    private static void rusiuotiSpalvas(Set<String> spalvos) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Spalvos pieš rūšiavimą");
        printColors();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Spalvos po rūšiavimo");
        spalvos.stream()
                .sorted()
                .forEach(System.out::println);

    }

    private static Set<String> enterColors() {

            printColors();
            String input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sudarykite arba papildykite");
            System.out.println("     spalvų sąrašą");
            System.out.println("    Įveskite spalvą");
            input = scanner.nextLine();
            colors.add(input);
            while (true) {

                System.out.println("Įveskite sekančią spalvą");
                System.out.println(" arba 'exit' kad išeiti");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    return colors;
                } else if (input.isEmpty()) {
                    continue;
                } else {
                    colors.add(input);
                }
                printColors();
            }
        }


    public static void printColors() {
        if (colors != null) {
        System.out.println("Esančios splavos");
        colors.stream()
                .forEach(System.out::println);
    }
    }

}
