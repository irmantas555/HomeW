package org.irmantas.hw0607;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitialiseAll {

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Arnas","Papilvis", LocalDate.of(2001,2,22),true));
        students.add(new Student("Agne","Kazlauskytė", LocalDate.of(1994,10,22),true));
        students.add(new Student("Benas","Jonynas", LocalDate.of(1988,8,2),false));
        students.add(new Student("Juratė","Abakavičienė", LocalDate.of(1996,6,3),true));
        students.add(new Student("Vidmantas","Federavičius", LocalDate.of(1992,2,12),true));
        students.add(new Student("Gražina","Gabalytė", LocalDate.of(1982,4,22),true));
        students.add(new Student("Paulius","Pabedinskas", LocalDate.of(1995,6,19),true));
        students.add(new Student("Jonė","Pecevičienė", LocalDate.of(1987,2,24),false));
        students.add(new Student("Tadas","Masalskis", LocalDate.of(1993,1,27),true));
        students.add(new Student("Austėja","Mackaitienė", LocalDate.of(2002,8,1),true));
        students.add(new Student("Joris","Dabažinskas", LocalDate.of(1996,9,29),false));
        students.add(new Student("Gustė","Rakštytė", LocalDate.of(1993,12,17),true));
        students.add(new Student("Liutauras","Jūrevičius", LocalDate.of(1994,10,13),true));
        students.add(new Student("Odilija","Kvedarienė", LocalDate.of(1997,2,8),true));
        students.add(new Student("Laurynas","Norvilas", LocalDate.of(1989,3,18),false));
        students.add(new Student("Emilija","Būgaitytė", LocalDate.of(2000,4,14),true));
        return students;
    }

    public static List<Trainer> getTrainers(){
        List<Trainer> trainers = new ArrayList<>();
        trainers.add(new Trainer("George","Stanquist",LocalDate.of(1984,12,3),true));
        trainers.add(new Trainer("Pavel","Starzinski",LocalDate.of(1987,05,22),true));
        trainers.add(new Trainer("Eimantas","Butnorius",LocalDate.of(1988,02,05),true));
        return trainers;
    }

    public static List<Group> getGroups(){
        List<Group> groups = new ArrayList<>();
        groups.add(new Group("Rising stars"));
        groups.add(new Group("New Hope"));
        groups.add(new Group("Stack eagles"));
        return groups;
    }
}

