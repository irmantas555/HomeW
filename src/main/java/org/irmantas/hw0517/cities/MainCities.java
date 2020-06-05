package org.irmantas.hw0517.cities;

import java.util.*;
import java.util.List;
import org.irmantas.hw0517.cities.*;

public class MainCities {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, List<City>> countries = new HashMap<>();
    static List<Country> countries1 = new ArrayList<>();

    public static void main(String[] args) {
        String coun;
        int optoion;
        Country austria = new Country("Austria");
        austria.addCity(new City("Vienna", 1_888_776, -500));
        austria.addCity(new City("Graz", 289_440, 1281));
        austria.addCity(new City("Linz", 193_814, 799));
        Country australia = new Country("Australia");
        australia.addCity(new City("Sydney", 5_312_163, 1788));
        australia.addCity(new City("Melbourne", 5_078_193, 1803));
        australia.addCity(new City("Brisbane", 2_514_184, 1824));
        Country haiti = new Country("Haiti");
        haiti.addCity(new City("Port-au-Prince", 1_234_742, 1492));
        haiti.addCity(new City("Cap-Haïtien", 534_815, 200));
        haiti.addCity(new City("Carrefour", 442_156, 475));
        Country southKorea = new Country("South Korea");
        southKorea.addCity(new City("Seul", 9_904_312, -18));
        southKorea.addCity(new City("Busan", 3_448_737, 1711));
        southKorea.addCity(new City("Incheon", 2_890_451, 1795));
        Country mexico = new Country("Mexico");
        mexico.addCity(new City("Mexico City", 8_851_080, 1325));
        mexico.addCity(new City("Ecatepec", 1_655_015, 1428));
        mexico.addCity(new City("Guadalajara", 1_495_182, 1532));
        countries1.add(austria);
        countries1.add(australia);
        countries1.add(haiti);
        countries1.add(southKorea);
        countries1.add(mexico);

        for (Country country : countries1
        ) {
            countries.put(country.getName(), country.getBigestCities());
        }

        while (true) {
            System.out.println("Pasirinkite kokią šalį norėsite peržiūrėti");
            System.out.println("    Arba įveskite 'exit kad išeiti'");
            displayCuntries();
            coun = scanner.nextLine();
            if (coun.isEmpty()) {
                continue;
            }
            if (coun.equals("exit")) {
                return;
            }
            Optional<List<City>> opCountry = Optional.ofNullable(countries.get(coun));
            if (!opCountry.isPresent()) {
                System.out.println("Rinkitės iš naujo");
                continue;
            } else {
                System.out.println("Šios šalies trys didžiausi miesta: ");
                for (City city : opCountry.get()
                ) {
                    System.out.println(city.getName() + ", jame yra " + city.getPopulation() + " gyventojų ir jis įkurtas " + city.getYearOfFoundation() + " metais");
                }
            }
        }
    }

    private static void displayCuntries() {
        for (String key : countries.keySet()) {
            System.out.println(key);
        }

    }
}
