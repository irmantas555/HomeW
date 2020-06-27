package org.irmantas.vehicle;

public class Bike implements Vehicle {
    VehicleBrand brand;
    VehicleModel model;
    private Person owner;

    public Bike(VehicleBrand brand, VehicleModel model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void setOwner(Person person) {
        this.owner = person;
        System.out.println(" Vehicle branded: " + brand  + " model: " +
                model + " owner now is-" + person.getFirstName() + " " + person.getLastName() +
                " borned " + person.getBirthDate().toString());
    }
}
