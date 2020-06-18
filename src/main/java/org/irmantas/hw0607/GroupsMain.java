package org.irmantas.hw0607;

import java.util.List;


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

        service.groupWithMaxJavaKnowHowStudents(groups);

        service.groupWithMaxJavaKnowHowStudentsRX(groups);
    }

}

