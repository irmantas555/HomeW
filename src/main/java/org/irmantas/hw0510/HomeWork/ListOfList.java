package org.irmantas.collections.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class ListOfList {
    public static void main(String[] args) {
    List<List<Integer>> multiTable = new ArrayList<>();
        List<Integer> table = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                table.add(i * j);
            }
            multiTable.add(new ArrayList<Integer>(table));
            table.clear();
        }

        multiTable.forEach(System.out::println);
    }


}
