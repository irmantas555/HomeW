package org.irmantas.hw0517.students;

import java.util.*;

public class SudentsMain {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static String searchPhrase;
    public static void main(String[] args) {
        students.addAll(StudentsFactory.fetchStudentList());
        enterStudent();
        evaluateStudents();
    }
    private static void evaluateStudents() {


        String option;
        while (true) {
        System.out.println("Pasirinkite ką darysime su studentų sąrašu");
        System.out.println("1 - Iškosime studentų");
        System.out.println("2 - pridėsime studentą");
        System.out.println("3 - atspausdinsime studentų kiekį");
        System.out.println("4 - suskaičiuoti studento vidurkį");
        System.out.println("5 - suskaičiuoti visų vidurkį");
        System.out.println("exit - išeiti iš sąrašo");
        option = scanner.nextLine();
            if (option.isEmpty()) {
                continue;
            } else if (option.equals("exit")) {
                return;
            }
            switch (option) {
                case "1":
                    findstudents();
                    break;
                case "2":
                    enterStudent();
                    break;
                case "3":
                    coutStudents();
                    break;
                case "4":
                    countSudentAvg();
                    break;
                case "5":
                    countAllAvg();
                    break;
                case "6":
                    findstudents();
                    break;
                default:
                    continue;
            }

        }

    }

    private static void countAllAvg() {
        OptionalDouble average = students.stream()
                .flatMap(student -> student.getGrade().stream())
                .mapToInt(Integer::intValue)
                .average();
        if (average.isPresent()) {
            System.out.println("Visų studentų vidurkis: " + average.getAsDouble());
        } else {
            System.out.println("Deja ivertinimų sąrašas tuščias");
        }
    }

    private static void countSudentAvg() {
        int option = 0;
        System.out.println("****************************************************");
        while (true) {
        System.out.println("Pasirinkite kurio studento vidurkį norite peržvelgti");
        System.out.println("arba įveskite 101 kad išeiti");

        students.forEach((student) -> System.out.println(students.indexOf(student) + " - " + student.getName()));
            try {
                option = scanner.nextInt();
                if (option == 101) {
                    return;
                }
                if (option > students.size() - 1 && option < 0) {
                    System.out.println("Pasirinkite iš sąrašo");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vis dėlto įveskite sakičių");
                continue;
            }
            OptionalDouble average = students.get(option).getGrade().stream()
                    .mapToInt(Integer::intValue)
                    .average();
            if (average.isPresent()) {
                System.out.println("Studento "+ students.get(option).getName() +" vidurkis: " + average.getAsDouble());
            } else {
                System.out.println("Deja ivertinimų sąrašas tuščias");
            }

        }

    }

    private static void coutStudents() {
        long count = students.stream().count();
        System.out.println("Turime " + count + " studentų");

    }

    private static void findstudents() {

        while (true) {
        System.out.println("Iveskite arba pavardę");
        System.out.println("arba 'exit' kad išeiti");
        searchPhrase = scanner.nextLine();
            if (searchPhrase.equals("exit")) {
                return;
            }
            students.stream()
                    .filter(student -> student.getName().contains(searchPhrase))
                    .forEach(student -> System.out.println("Ieškomas studentas - " + student.getName()));
        }
    }



    private static void enterStudent() {
        String name;
        int grade;
        boolean finishGrades = true;
        System.out.println("***********************************");
        System.out.println("    Dabar įvęsime studentus");
        while (true) {
            Student student = new Student();
            System.out.println("    Iveskite vardą ir pavardę");
            System.out.println("     arba exit kad išeiti");
            name = scanner.nextLine();
            if (name.equals("exit")) {
                return;
            }
            if (name.isEmpty()) {
                System.out.println("Reikia vardo");
                continue;
            }
            student.setName(name);
            while (finishGrades) {
                System.out.println("***********************************");
                System.out.println("        iveskite gautą balą ");
                System.out.println("arba 101 kad baigti ivedinėti balus");
                try {
                    grade = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Reikia ivęsti skaičių");
                    scanner.next();
                    continue;
                }
                if (grade == 101) {
                    finishGrades = false;
                }
                if (Optional.ofNullable(grade).isPresent()) {
                    student.setGrade(grade);
                } else {
                    continue;
                }

            }
            students.add(student);
        }
    }
}
