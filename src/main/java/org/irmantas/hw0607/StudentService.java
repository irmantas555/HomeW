package org.irmantas.hw0607;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.function.Tuple2;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentService {

    public static void sortedStudentGroupByLastName(Set<Student> students) {
        students.stream()
                .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                .forEach(System.out::println);
    }

    public static void sortedStudentGroupByLastNameRx(Set<Student> students) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Sorted group by last name");
        Observable.fromIterable(students)
                .sorted(Comparator.comparing(Student::getLastName))
                .subscribe(System.out::println);
    }

    public static Group addStudentsToGroup(Group group, List<Student> students) {
        Random anyStudent = new Random();
        Random randomSteudentsQty = new Random();
        int thisGroupRandomBound = randomSteudentsQty.nextInt(2);
        Student nextStudent;
//        System.out.println("Students for group: " + group.getName());
        for (int i = 0; i < thisGroupRandomBound + 2; i++) {
            nextStudent = students.get(anyStudent.nextInt(students.size()));
            try {
                group.addStudent(nextStudent);
//                System.out.println("Trying to add: " + nextStudent);
            } catch (MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
                System.out.println(maximumNumberOfStudentsReached.getMessage());
                return group;
            }

        }
        return group;
    }


    public void getBiggestGroup(List<Group> groups) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Biggest group");
        Optional<Group> biggest = groups.stream()
                .max(Comparator.comparing(group -> group.getStudents().size()));
        if (biggest.isPresent()) {
            System.out.println("Bigest group of students is in group: " + biggest.get().getName() +
                    " stundents qty in it is: " + biggest.get().getStudents().size());
        }

    }

    public void getStudentsYoungerThan(int ageLimit) {


    }

    public void getStudentsYoungerThan(int ageLimit, List<Group> groups) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Students younger than " + ageLimit);
        Observable.fromIterable(groups)
                .flatMap(group -> Observable.fromIterable(group.getStudents()))
                .filter(student -> getage(student) < ageLimit)
                .distinct()
                .forEach(student -> System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " which age is: " + getage(student)));
    }

    private int getage(Student student) {
        int age = 0;
        age = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
        return age;
    }

    public void removeStudentsYoungerThan(int ageLimit, List<Group> groups) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Students younger than " + ageLimit + " removal");
      groups.stream()
                .peek(group -> {
                            Iterator studentIterator = group.getStudents().iterator();
                    while (studentIterator.hasNext()) {
                        if (getage((Student) studentIterator.next()) < ageLimit) {
                            studentIterator.remove();
                        }
                    }
                })
        .forEach(group -> System.out.println(group.getName() +"\n" + group.printStudents()));

    }

    private Group removeStudThisGroup(Group group, int ageLimit) {

            for (Student st : group.getStudents()
            ) {
                if (getage(st) < ageLimit) {

                    group.removeStudent(st);

                    System.out.println("Student: " + st.getFirstName() + " " + st.getLastName() +
                            " which age is: " + getage(st) + " has been removed from group: " + group.getName());
                }
        }
        return group;
    }

    public void studentsWithPreviousJavaKnowledge(List<Student> students) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Students with previous JAVA knowledge");
        Observable.fromIterable(students)
                .filter(student -> student.isHasPreviousJavaKnowledge())
                .forEach(student -> System.out.println(student));
    }

    public void groupWithMaxJavaKnowHowStudents(List<Group> groups) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Max students qty in group with previous JAVA knowledge");
        int maxQty = 0;
        ArrayList<Group> max = new ArrayList<>();
        int counter = 0;
        for (Group group :groups
             ) {
            for (Student student:group.getStudents())
                if (student.isHasPreviousJavaKnowledge()) {
                    counter++;
                }
            if (counter > maxQty) {
                max.clear();
                max.add(group);
                maxQty = counter;
            } else if (counter == maxQty)
                max.add(group);
            counter = 0;
        }

        System.out.println("Grup with highest number of Java fluent students is: " + max.toString() + " and fluent students quantity in it is " + maxQty);

    }

    public void groupWithMaxJavaKnowHowStudentsRX(List<Group> groups) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Students with previous JAVA knowledge in Reactive Fashion");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        Single<Map<String, Long>> mapSingle = Observable.fromIterable(groups)
                .toMap(group -> group.getName(), group ->
                        Observable.fromIterable(group.getStudents())
                                .map(student -> student.isHasPreviousJavaKnowledge())
                                .filter(Boolean::booleanValue)
                                .count()
                                .blockingGet()
                );
        Map<String, Long> stringLongMap = mapSingle.blockingGet();

        Map.Entry<String, Long> entry = stringLongMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();
        System.out.println("Group with highest fluent Java sudents: " + entry.getKey() + " there are - " + entry.getValue() + " Java fluent students in it");


        Optional<Map.Entry<String, Integer>> max = Flux.fromIterable(groups)
                .reduce(new HashMap<String, Integer>(), (aggr, gr) -> {
                    aggr.put(gr.getName(), gr.fluentCount(gr.getStudents()));
                    return aggr;
                })
                .flatMap(stringIntegerHashMap -> Mono.just(stringIntegerHashMap.entrySet()))
                .flux()
                .toStream()
                .flatMap(Collection::stream)
                .max((o1, o2) -> o1.getValue() - o2.getValue());

        System.out.println("Group optional with highest fluent Java sudents: " + max.get().getKey() + " there are - " + max.get().getValue() + " Java fluent students in it");

        Flux.fromIterable(groups)
                .reduce(new HashMap<String, Integer>(), (aggr, gr) -> {
                    aggr.put(gr.getName(), gr.fluentCount(gr.getStudents()));
                    return aggr;
                })
                .flatMap(str -> findThatMax(str))
                .subscribe(sInEntry -> System.out.println("Function Group with highest fluent Java sudents: " + sInEntry.getKey()
                        + " there are - " + sInEntry.getValue() + " Java fluent students in it"));


    }

    private Mono<Map.Entry<String,Integer>> findThatMax(HashMap<String, Integer> str) {
        Optional<Map.Entry<String, Integer>> max = str.entrySet().stream()
                .max((o1, o2) -> o1.getValue()-o2.getValue());

            Map.Entry<String,Integer> maxValue = max.get();

            return Mono.just(maxValue);

    }




}
