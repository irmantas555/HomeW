package org.irmantas.hw0510.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenExercise {
    public static void main(String[] args) {
        Person aiste = new Person("Aiste", "Paulauskienė", 185);
        Person petras = new Person("Petras", "Juodsnukis", 168);
        Person egle = new Person("Egle", "Gaižauskienė", 160);
        Person robertas = new Person("Robertas", "Matulionis", 165);

        List<Person> sarasiuks = new ArrayList<>();
        sarasiuks.add(petras);
        sarasiuks.add(egle);
        sarasiuks.add(robertas);
        sarasiuks.add(aiste);

        sarasiuks.forEach(System.out::println);
        Collections.sort(sarasiuks);
        sarasiuks.forEach(System.out::println);

        List<Generc> bendras = new ArrayList<>();

        Integer i = Integer.valueOf(52);
        String s = "string";
        Double d = Double.valueOf(7.0);

        Generc<Integer> intt = new Generc<>(i);
        Generc<String> sttr = new Generc<>(s);
        Generc<Double> dbbl = new Generc<>(d);

        bendras.add(intt);
        bendras.add(sttr);
        bendras.add(dbbl);

        bendras.forEach(b -> {
            System.out.println("Objeklto reksmė" + b.getObject());
        });

    }
}

class Generc<T> {
    Object object;

    public Generc(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

