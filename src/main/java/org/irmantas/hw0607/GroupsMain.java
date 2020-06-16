package org.irmantas.hw0607;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;



public class GroupsMain {
        static StudentService service = new StudentService();
    public static void main(String[] args) {
        List<Student> students = InitialiseAll.getStudents();
        List<Trainer> trainers = InitialiseAll.getTrainers();
        List<Group> groups = InitialiseAll.getGroups();
        System.out.println("Sudent size" + students.size());

        groups.stream()
                .map(group -> service.addStudentsToGroup(group,students))
                .flatMap(group -> group.getStudents().stream())
                .forEach(System.out::println);

        service.sortedStudentGroupByLastNameRx(groups.get(1).getStudents());

        service.getBiggestGroup(groups);

        service.getStudentsYoungerThan(25,groups);



        service.studentsWithPreviousJavaKnowledge(students);

        service.removeStudentsYoungerThan(20,groups);

        service.gropWithMaxJavaKnowHowStudents(groups);
    }


    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

