package org.irmantas.hw0607;

import io.netty.handler.ssl.util.SimpleTrustManagerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
 private String firstName;
 private String lastName;
 private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
