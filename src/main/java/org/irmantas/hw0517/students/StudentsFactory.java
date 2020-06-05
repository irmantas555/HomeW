package org.irmantas.hw0517.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsFactory {
    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student("Petras Pajaujis", Arrays.asList(4, 7, 8, 5, 8, 9, 7, 8)));
        students.add(new Student("Ausra Mildazyte", Arrays.asList(4,5,8,9,34,7,7,4,6,5,4)));
        students.add(new Student("Guzas Nerealus", Arrays.asList(3,3,5,7,2,9,4,7,78,25,4,4,4)));
        students.add(new Student("Siokstoks Mokslovyras", Arrays.asList(7,8,9,7,6,5,4,5,6,5,4,9,8,7,9,4,6,4,5,6,8,7,9)));
        students.add(new Student("Gražina Pagriežlienė", Arrays.asList(4,7,9,7,7,9,9,8,7)));
    }

    public static List<Student> fetchStudentList() {
        return students;
    }
}
