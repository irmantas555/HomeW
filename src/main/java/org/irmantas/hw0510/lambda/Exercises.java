package org.irmantas.hw0510.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {
    public static void main(String[] args) throws IOException {

        ArithmeticOperations addition = (a, b) -> a + b;
        ArithmeticOperations substraction = (a, b) -> a - b;
        ArithmeticOperations multiplication = (a, b) -> a * b;
        ArithmeticOperations division = (a, b) -> a / b;

        System.out.println(perfomOperations(4,6,addition));
        System.out.println(perfomOperations(4,6,substraction));
        System.out.println(perfomOperations(24,6,division));
        System.out.println(perfomOperations(4,6,multiplication));

        IntStream stream = IntStream.of(1,5,87,24,564,654,54);
        int sum = stream.sum();
        System.out.println("Sum of int stream: "+sum);

        Path filePath = Paths.get(".\\src\\main\\java\\org\\irmantas\\lambda\\txtFile.txt");


        List<String> lines = Files.readAllLines(filePath);

        Function<String, Stream<String>> toWords = s -> Pattern.compile("[,.]? ").splitAsStream(s);

        List<String> words = lines.stream()
                .flatMap(toWords)
                .collect(Collectors.toCollection(ArrayList::new));

        words.stream()
                .peek(System.out::println)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);

        System.out.println("Sum of words in file: ");
    }

    public static int perfomOperations(int a, int b, ArithmeticOperations arithmeticOperations) {
        int rezult = arithmeticOperations.operate(a,b);
        return rezult;
    }



}

 interface ArithmeticOperations {
     int operate(int a, int b);
}