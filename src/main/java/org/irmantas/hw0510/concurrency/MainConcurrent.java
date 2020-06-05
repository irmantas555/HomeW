package org.irmantas.hw0510.concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConcurrent {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String emlp;
        ThreadGroup myTGroup = new ThreadGroup("shift");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Irmantas", "HR"));
        employees.add(new Employee("Petras", "Accounting"));
        employees.add(new Employee("Tadas", "Logistics"));
        employees.add(new Employee("Agne", "Supply"));
        employees.add(new Employee("Milda", "IT"));

        for (Employee employee : employees
        ) {
            new Thread(new WorkShift(employee), employee.getName()).start();
        }

            while (true) {
                try {
                    Thread.sleep(31000);
                    Employee removable = pickOne(employees);
                    removeOne(employees,removable);
                    if (employees.size() == 1) {
                        System.out.println("Removing last employee");
                        removable.setContinueToWork(false);
                        employees.get(0).setContinueToWork(false);
                    return;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


    }

    private static Employee pickOne(List<Employee> employees) {
        for (Employee employee:employees
             ) {
            System.out.println("Pasirink paleidžiamą darbuotoją");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(i + " - " + employees.get(i).getName());
            }
            String darbNr = scanner.nextLine();
            return employees.get(Integer.parseInt(darbNr));
        }
        return null;
    }

    private static void removeOne(List<Employee> employees) {
        System.out.println("One man down, lets get faster");
        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                employees.get(i).setContinueToWork(false);
            } else {
                employees.get(i).setCycleTime(employees.get(i).getCycleTime() - 2000);
            }
        }
        if (employees.size() == 1) {
            System.out.println("Removing last employee");
            employees.remove(0);

        } else {
            employees.remove(0);
        }
    }
    private static void removeOne(List<Employee> employees, Employee employee) {
        System.out.println("One man down, lets get faster");
            employee.setContinueToWork(false);
            employees.remove(employee);
        for (Employee emp:employees
             ) {
            emp.setCycleTime(emp.getCycleTime() - 2000);
        }
    }

//    public static void eitiNamo(String name, List<Employee> employees) {
//        for (Employee empl : employees
//        ) {
//            if (empl.getName().equals(name)) {
//                System.out.println(name + ": <time "+getHours()+">, it's time to go home!");
//                employees.remove(empl);
//            }
//        }
//    }

    public static String getHours() {
        DateTimeFormatter hm = DateTimeFormatter.ofPattern("HH:mm");
        String dt = hm.format(LocalDateTime.now());
        return dt;
    }
}


class WorkShift implements Runnable {
    Employee employee;

    public WorkShift(Employee employee) {
        this.employee = employee;
    }


    @Override
    public void run() {
        System.out.println("<" + employee.getName() + ": I came to work at " + MainConcurrent.getHours() + " >");
        while (employee.isContinueToWork()) {
            try {
                Thread.sleep(employee.getCycleTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(employee.getName() + ": I’m still working!");
        }
        System.out.println(employee.getName() + ": <time " + MainConcurrent.getHours() + ">, it's time to go home!");
    }
}