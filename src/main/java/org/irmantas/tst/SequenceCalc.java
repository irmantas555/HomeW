package org.irmantas.tst;


import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class SequenceCalc {
    public SequenceCalc() {
    }

    public Double sequenceOperations(String sequence,double previous) {
        List<String> d = Observable.just(sequence)
                .map(s -> s.trim())
                .map(s -> s.replaceAll("[a-zA-Z]",""))
                .flatMap(s -> Observable.fromArray(s.split("[^0-9.]")))
                .toList()
                .blockingGet();

        List<String> o = Observable.just(sequence)
                .map(s -> s.trim())
                .flatMap(s -> Observable.fromArray(s.split("[0-9.a-zA-Z]")))
                .filter(s -> !s.equals("") && !s.equals("."))
                .toList()
                .blockingGet();

//        d.forEach(System.out::println);
//        System.out.println();
//        o.forEach(System.out::print);
        if (previous == 0.00) {
            Double rezult = operationSequenceRezult(d, o);
        return rezult;
        } else {
            Double rezult = operationSequenceRezultPrev(d, o, previous);
        return rezult;
        }

    }

    public Double operationSequenceRezultPrev(List<String> d, List<String> o, double previous) {
        Double rez = previous;
        Double second;
        String operation;
        for (int i = 0; i < d.size(); i++) {
            second = Double.parseDouble(d.get(i));
            rez = red(rez, o.get(i), second);
        }
        return rez;
    }

    public   Double operationSequenceRezult(List<String> d, List<String> o) {
        Double rez = Double.parseDouble(d.get(0));
        Double second;
        String operation;
        for (int i = 1; i < d.size(); i++) {
            second = Double.parseDouble(d.get(i));
            rez = red(rez, o.get(i - 1), second);
        }
        return rez;
    }

    public   Double red(Double first, String st, Double second) {
        double rez;
        switch (st) {
            case "+":
                rez = first + second;
                break;
            case "/":
                rez = first / second;
                break;
            case "*":
                rez = first * second;
                break;
            case "-":
                rez = first - second;
                break;
            default:
                rez = first;
                break;

        }
        return rez;

    }
}
