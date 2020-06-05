package org.irmantas.hw0517.cities;

import java.util.Date;

public class City {
    private String name;
    private int population;
    private int yearOfFoundation;

    public City(String name, int population, int yearOfFoundation) {
        this.name = name;
        this.population = population;
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", yearOfFoundation=" + yearOfFoundation +
                '}';
    }
}
