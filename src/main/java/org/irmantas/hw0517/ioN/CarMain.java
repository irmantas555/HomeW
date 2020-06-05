package org.irmantas.hw0517.ioN;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarMain {
    static Scanner scanner = new Scanner(System.in);
    static List<Car> carList = new ArrayList<>();
    static Path pw = FileSystems.getDefault().getPath("src\\main\\java\\org\\irmantas\\hw0517\\ioN\\car.dat");

    public static void main(String[] args) throws IOException {
        Path pp = FileSystems.getDefault().getPath("src\\main\\java\\org\\irmantas\\hw0517\\ioN\\cars.txt");
        List<String> stringFile = readNioFileToStrings(pp);
        carList = parseCarList(stringFile);
        proceedOptions();

    }

    private static void proceedOptions() {
        int option;
        while (true) {

            System.out.println("***********************************");
            System.out.println("Ka norite daryti su mašinu sąrašu?");
            System.out.println("1 - atspausdinti sąrašą");
            System.out.println("2 - įvęsti naują mašiną");
            System.out.println("3 - išrušiuoti sąrašą");
            System.out.println("4 - irašyti sąraša ir pabaigti");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    printCarList();
                    break;
                case 2:
                    enterCar();
                    break;
                case 3:
                    orderList();
                    break;
                case 4:
                    writeAndExit();
                    return;
            }


        }

    }

    private static void writeAndExit() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(pw, StandardOpenOption.CREATE)))) {
            for (Car car : carList
            ) {
                writer.writeObject(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    private static void orderList() {
        carList.stream()
                .sorted(Comparator.comparing(Car::getMake))
                .forEach(car -> System.out.println(car));
    }

    private static void enterCar() {
        Car car = new Car();
        System.out.println("********************");
        System.out.println("Įveskite naujos mašinos gamintoją");
        car.setMake(scanner.next());
        System.out.println("Įveskite naujos mašinos modelį");
        car.setModel(scanner.next());
        System.out.println("Įveskite modelio gamybos pradžios metus");
        car.setProductionBeginYear(scanner.next());
        System.out.println("Įveskite modelio gamybos pabigos metus, jei dar gaminama ivedam 'present'");
        car.setProductionEndYear(scanner.next());
        System.out.println("Įveskite modelio durų kiekį");
        car.setDoorQty(scanner.nextInt());
        System.out.println("Įveskite modelio kebulo tipą");
        car.setBodyStyle(scanner.next());
        carList.add(car);
    }

    private static void printCarList() {
        carList.stream().forEach(car -> System.out.println(car));
    }

    public static List<String> readFileToStrings(File file) throws FileNotFoundException {
        List<String> wholeFile = new ArrayList<>();
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (reader.hasNextLine()) {
                wholeFile.add(reader.nextLine());
            }
        }
        System.out.println("Failas nuskaitytas");
        return wholeFile;
    }

    public static List<String> readNioFileToStrings(Path path) throws IOException {
        List<String> wholeFile = Files.readAllLines(path);
        System.out.println("Failas nuskaitytas");
        return wholeFile;
    }

    public static List<Car> parseCarList(List<String> carList) {
        List<Car> tempoList = carList.stream()
                .map(string -> getCar(string))
                .collect(Collectors.toList());
        return tempoList;
    }

    private static Car getCar(String s) {
        String[] parts = s.split(" ");
        try {
            if (parts.length == 7) {
                Car tempCar = new Car(parts[0], parts[1], parts[2], parts[4], Integer.parseInt(parts[5].substring(0, 1)), parts[6]);
                return tempCar;
            } else if (parts.length == 8) {
                Car tempCar = new Car(parts[0], parts[1] + " " + parts[2], parts[3], parts[5], Integer.parseInt(parts[6].substring(0, 1)), parts[7]);
                return tempCar;
            } else if (parts.length == 9) {
                Car tempCar = new Car(parts[0], parts[1] + " " + parts[2]+ " " + parts[3], parts[4], parts[6], Integer.parseInt(parts[7].substring(0, 1)), parts[8]);
                return tempCar;
            }

        } catch (NumberFormatException e) {
            System.out.println("Kažkas su numeriais");
        }
            return null;
    }

    private static void getDatCars() throws IOException, ClassNotFoundException {
        Car tempCar = new Car();
        try (ObjectInputStream readStream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(pw)))){
            while (true)
                try {
                    carList.add((Car) readStream.readObject());
                } catch (EOFException e) {
                    return;
                }
        }
    }



}
