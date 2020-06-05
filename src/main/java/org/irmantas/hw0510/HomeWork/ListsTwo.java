package org.irmantas.collections.HomeWork;

import java.util.*;

public class ListsTwo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> ratings = enterRatings();
        displayAvarage(ratings);
    }

    private static void displayAvarage(List<Integer> ratings) {
        if (ratings != null) {
            OptionalDouble av = ratings.stream()
            .mapToInt(Integer::intValue)
                    .average();
            System.out.printf("Avarage value for ratings is %.2f%n",av.getAsDouble());
        }

    }

    private static List<Integer> enterRatings() {
        List<Integer> ratings = new ArrayList<>();
        int input = 0;
        while (true) {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("Enter rating value from one to six");
            System.out.println("      to quit enter '101'");
            try {
                input = scanner.nextInt();
                if (input == 101) {
                    return ratings;
                } else if (input > 6 || input < 1) {
                    System.out.println("Value should be between 1 and 6");
                    continue;
                }
                ratings.add(input);
            } catch (InputMismatchException e) {
                System.out.println("Input should be integer");
                scanner.next();
                continue;
            }
        }
    }
}
