package org.irmantas.hw0607;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String name;
    private Trainer trainer;
    private Set<Student> students = new HashSet<>();

    public Group(String name, Trainer trainer) {
        this.name = name;
        this.trainer = trainer;
    }

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) throws MaximumNumberOfStudentsReached {
        if (students.isEmpty() || students.size() < 5) {
            students.add(student);
        } else {
            throw new MaximumNumberOfStudentsReached("Maximum number of students exceeds 5");
        }
    }

    public void removeStudent(Student student) {
        synchronized (this) {
            students.remove(student);
        }
    }


    public Group() {
    }

    public String getName() {
        return name;
    }

    public String printStudents() {
        StringBuilder studentsBuilder = new StringBuilder("");
        for (Student stud : students
        ) {
            studentsBuilder.append("Student: " + stud.getFirstName() + " " + stud.getLastName() + " has previous Java knowlwgde: " + stud.isHasPreviousJavaKnowledge() + "\n");
        }
        return studentsBuilder.toString();
    }


    public Trainer getTrainer() {
        return trainer;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public int fluentCount(Set<Student> students) {
        long count = students.stream()
                .map(Student::isHasPreviousJavaKnowledge)
                .filter(Boolean::booleanValue)
                .count();
        return (int) count;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}

class MaximumNumberOfStudentsReached extends Exception {
    public MaximumNumberOfStudentsReached(String error) {
        super(error);
    }
}