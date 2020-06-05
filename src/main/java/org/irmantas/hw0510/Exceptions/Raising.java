package org.irmantas.hw0510.Exceptions;

import java.io.*;
import java.util.*;

public class Raising {
    static Scanner scanner = new Scanner(System.in);
    static int sum;
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        String inputLine = null;
       //enter many
        for (int i = 0; i < 100; i++) {
            inputLine = scanner.nextLine();
            data.add(inputLine);
        }
        //before close
        if (writeBeforeExit(data)) {
            System.out.println("Bye");

        } else {
            //write to some datbase
        }

    }

    public static boolean writeBeforeExit(List<String> data) {
        List<Integer> sarasas = new ArrayList<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {
            for (String s:data
                 ) {
                writer.write(s);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static List<String> readOnOpen() throws MyException {
        List<String> data = new ArrayList<>();
        String line = null;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("file.txt")))) {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                data.add(line);
            }
        } catch (IOException e) {
            throw new MyException("Nuskaityti nepavyko, tai dirbti nebus su kuo");
        }

        return data;
    }


}

class MyException extends Exception {
    public MyException(String exception) {
        System.out.println(exception);
    }
}
