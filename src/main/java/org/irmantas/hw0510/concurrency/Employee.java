package org.irmantas.hw0510.concurrency;

public class Employee {
    private String name;
    private String department;
    private int cycleTime;
    private boolean continueToWork;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        cycleTime = 10000;
        continueToWork = true;

    }

    public int getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(int cycleTime) {
        this.cycleTime = cycleTime;
    }

    public void setContinueToWork(boolean continueToWork) {
        this.continueToWork = continueToWork;
    }

    public boolean isContinueToWork() {
        return continueToWork;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
