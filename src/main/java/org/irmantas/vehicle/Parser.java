package org.irmantas.vehicle;

import java.time.LocalDate;

public class Parser {
    private String data;
    private Person person;

    public Person getPerson(String data) {
        try {
            String[] all = data.split(" ");
            Person tempPerson = new Person();
            tempPerson.setFirstName(all[0]);
            tempPerson.setLastName(all[1]);
            String[] dateData = all[3].split("/");
            int year = Integer.parseInt(dateData[2]);
            int month = Integer.parseInt(dateData[1]);
            int dayOfMonth = Integer.parseInt(dateData[0]);
            tempPerson.setBirthDate(LocalDate.of(year, month, dayOfMonth));
            return tempPerson;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

}
