package org.irmantas.hw0510.generic;

public class Person implements Comparable{
    private String firstName;
    private String lastName;
    private int heightInCm;

    public Person(String firstName, String lastName, int heightInCm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInCm = heightInCm;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    @Override
    public int compareTo(Object o) {
        Person person =(Person)o;
        return this.getHeightInCm()-person.getHeightInCm();   }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightInCm=" + heightInCm +
                '}';
    }
}
