package org.irmantas.hw0517.cities;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private List<City> bigestCities = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getBigestCities() {
        return bigestCities;
    }

    public void addCity(City city) {
        bigestCities.add(city);
    }
}
