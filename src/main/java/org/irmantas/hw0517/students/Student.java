package org.irmantas.hw0517.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    static int counter = 0;
    private String name;
    private List<Integer> evaluations = new ArrayList<>();

    public Student() {
    }

    public Student(String name, List<Integer> evaluations) {
        this.name = name;
        this.evaluations = evaluations;
        id = ++counter;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        evaluations.add(grade);
    }

    public List<Integer> getGrade() {
        return evaluations;
    }

}
