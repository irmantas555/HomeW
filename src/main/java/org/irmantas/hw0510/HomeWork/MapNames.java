package org.irmantas.collections.HomeWork;

import java.util.*;

public class MapNames {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//      Map<String, String> namesSureNames = enterNamesandSurenamesMap();
//        Map<String, Integer> namesAges = enterNamesAgesMap();
//        Map<String, List<String>> namesFiredList = enterNamesFriendsMap();
        Map<String, Map<String, String>> namesDetails = enterDetailsMap();


    }

    private static Map<String, Map<String, String>> enterDetailsMap() {
        Map<String, Map<String, String>> nameAndDetails = new HashMap<>();
        String name, detail, val;
        boolean check = true;
        while (true) {
            System.out.println("Ivesime žmogų ir jo duomenis");
            System.out.println("norint išeiti įvesk 'exit'");
            System.out.println("Įvesk vardą");
            name = scanner.nextLine();
            if (name.equals("exit")) {
                System.out.println("Štai ką suvedėm: ");
                printMap(nameAndDetails);
                return nameAndDetails;
            }
            Map<String, String> details = new HashMap<>();
            while (check) {
                System.out.println("Ivesime duomenis");
                System.out.println("norint išeiti įvesk 'exit' ");
                System.out.println("Ivesk ka nori ivesti(pvz gimimmo data, ūgis, svoris)");
                detail = scanner.nextLine();
                if (detail.equals("exit")) {
                    check = false;
                } else {
                    System.out.println("Ivesk reikšmę)");
                    val = scanner.nextLine();
                    if (detail.isEmpty() || val.isEmpty()) {
                        System.out.println("Tuščių negalima iš naujo");
                        continue;
                    }
                    details.put(detail, val);
                    continue;
                }
            }
            nameAndDetails.put(name, details);
//            details.clear();
            check = true;
        }
    }


    private static Map<String, List<String>> enterNamesFriendsMap() {
        Map<String, List<String>> friendMap = new HashMap<>();
        List<String> friends = new ArrayList<>();
        String name, friendName;
        boolean check = true;
        while (true) {
            System.out.println("Ivesime žmogų ir jo draugus");
            System.out.println("norint išeiti įvesk 'exit' ");
            System.out.println("Įvesk vardą");
            name = scanner.nextLine();
            if (name.equals("exit")) {
                System.out.println("Štai ką suvedėm: ");
                if (!friendMap.isEmpty()) {
                    printMap(friendMap);
                } else {
                    System.out.println("Ogi nieko");
                }
                return friendMap;
            }
            friends:
            while (check) {
                System.out.println("Įvesk 'exit' jei užteks tų draugų");
                System.out.println("Įvesk jo draugus");
                friendName = scanner.nextLine();
                if (friendName.equals("exit")) {
                    check = false;
                } else {
                    friends.add(friendName);
                }
            }
            if (name.isEmpty() || friends.isEmpty()) {
                System.out.println("Tuščių negalima iš naujo");
                continue;
            }
            friendMap.put(name, friends);
        }
    }

    private static Map<String, Integer> enterNamesAgesMap() {
        Map<String, Integer> namesAges = new HashMap<>();
        String first, second;
        boolean check;
        while (true) {
            System.out.println("Ivesk vardus ir amžius");
            System.out.println("norint išeiti įvesk 'exit' ");
            System.out.println("Įvesk vardą");
            first = scanner.nextLine();
            if (first.equals("exit")) {
                System.out.println("Štai ką suvedėm: ");
                if (!namesAges.isEmpty()) {
                    printMap(namesAges);
                } else {
                    System.out.println("Ogi nieko");
                }
                return namesAges;
            }
            System.out.println("Įvesk amžių");
            second = scanner.nextLine();
            if (first.isEmpty() || second.isEmpty()) {
                System.out.println("Tuščių negalima iš naujo");
                continue;
            } else if (!checkInput(second)) {
                System.out.println("Turi būti skaičius, iš naujo");
                continue;
            }
            namesAges.put(first, Integer.parseInt(second));
            continue;
        }

    }

    private static Map<String, String> enterNamesandSurenamesMap() {
        Map<String, String> namesFirstLast = new HashMap<>();
        String first, second;
        while (true) {
            System.out.println("Ivesk vardus ir paverdes");
            System.out.println("norint išeiti įvesk 'exit' ");
            System.out.println("Įvesk vardą");
            first = scanner.nextLine();
            if (first.equals("exit")) {
                System.out.println("Štai ką suvedėm: ");
                if (!namesFirstLast.isEmpty()) {
                    printMap(namesFirstLast);
                } else {
                    System.out.println("Ogi nieko");
                }
                return namesFirstLast;
            }
            System.out.println("Įvesk pavardę");
            second = scanner.nextLine();
            if (first.isEmpty() || second.isEmpty()) {
                System.out.println("Tuščių negalima iš naujo");
                continue;
            } else namesFirstLast.put(first, second);
            continue;
        }

    }

    private static boolean checkInput(String input) {
        long co = input.chars()
                .filter(num -> num >= 48 && num <= 57)
                .count();
        if ((int) co != input.length()) {
            return false;
        }
        return true;
    }

    public static void printMap(Map mapsas) {
        mapsas.entrySet().forEach(System.out::println);
    }


}

