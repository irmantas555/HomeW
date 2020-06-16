package org.irmantas.hw0607;

import java.time.LocalDate;

public class Trainer  extends Person{
    private boolean isAuthorized;

    public Trainer(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth, boolean isAuthorized) {
        super(firstName, lastName, dateOfBirth);
        this.isAuthorized = isAuthorized;
    }
}
