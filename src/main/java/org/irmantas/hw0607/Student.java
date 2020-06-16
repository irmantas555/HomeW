package org.irmantas.hw0607;

import java.time.LocalDate;

public class Student extends Person {
    private boolean hasPreviousJavaKnowledge;

    public Student(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    @Override
    public String toString() {
        return "Student{" +
                " First name = " + super.getFirstName() +
                " Last name = " + super.getLastName() +
                " Date of birth = " + super.getDateOfBirth().toString() +
                " hasPreviousJavaKnowledge = " + hasPreviousJavaKnowledge +
                '}';
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }
}
