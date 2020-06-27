package org.irmantas.vehicle;

import java.util.Scanner;

public class VehicleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Bike bike = new Bike(VehicleBrand.PANTHER, VehicleModel.BETA);
        System.out.println("Enter owner in format: name surename 'born' dd/mm/yyyy");
        String personData = scanner.nextLine();
        // scanner.next();
        Person newOwner = parser.getPerson(personData);
        if (newOwner != null) {
           bike.setOwner(newOwner);
        }



    }
}
