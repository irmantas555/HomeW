package org.irmantas.IO.homework;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyIoHome {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(".\\src\\main\\java\\org\\irmantas\\IO\\homework\\text.txt");

        List<String> lines = Files.readAllLines(file);
        Function<String, Stream<String>> words =
                line -> Pattern.compile("[,.]? ").splitAsStream(line);

//                line -> Stream.of(line.split("  "));
        List<String> wordList = lines.stream()
                .flatMap(words)
//                .peek(System.out::println)
                .collect(Collectors.toList());


        int wordCount = wordList.size();

        IntUnaryOperator intUnaryOperator = i->++i;

        List<Character> wholeFileChars = lines.stream()
                .reduce("", (ps, line) -> ps + line)
                .chars()
                .mapToObj(i -> new Character((char)i))
                .collect(Collectors.toList());




//                .forEach(System.out::println);

        long charCount = wholeFileChars.stream()
                .filter(character -> character <= 65 || character >= 90 && character <= 97 || character >= 122)
                .count();

        System.out.println("Words in my file: " + wordCount);
        System.out.println("Special characer in my file: " + charCount);


        Function<String,Integer> charCountInWord = s -> s.length();

        IntUnaryOperator iu = i->++i;


        Map<Integer,List<String>> wordMap = wordList.stream()
                .distinct()
                .collect(Collectors.groupingBy(charCountInWord));

        wordMap.entrySet().stream()
                .sorted((e1,e2)->-e1.getKey().compareTo(e2.getKey()))
                .limit(5)
                .forEach(ile -> System.out.println("Words with most letters " + ile.getKey() + ":" + ile.getValue()));


        Map<String,Long> wordMapByApearacces = wordList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        List<Integer> topWordByApp = wordMapByApearacces.entrySet().stream()
                .mapToInt(value -> Math.toIntExact(value.getValue()))
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(5)
                .peek(System.out::println)
                .collect(Collectors.toList());

        for (int i=0;i<topWordByApp.size();i++) {
            for (Map.Entry<String, Long> entry : wordMapByApearacces.entrySet()
            ) {
                if (entry.getValue() == (long) topWordByApp.get(i)) {
                System.out.println("Sitas zodis: " + entry.getKey() + " pagal dažnumą yra " + (i+1) + " jis pasikartojo " + topWordByApp.get(i) +
                        " kartu");
                    break;
                }
            }
        }


//        System.out.println("Special characer in my file: " + wordMap);



    }
}
