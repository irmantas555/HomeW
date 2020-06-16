package org.irmantas.tst;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;


public class testCalc {
    static SequenceCalc sequenceCalc = new SequenceCalc();

    public static void main(String[] args) {
//        Double dd = sequenceCalc.sequenceOperations("89*347-87/2", 0.00);
//        System.out.println(dd);

        String[] separated = "89*347-87/2".split("[^0-9]");
        Arrays.asList(separated).stream()
                .forEach(System.out::println);

        String[] sep = "89*347-87/2".split("");
        Arrays.asList(sep).stream()
                .forEach(System.out::println);

//        Flowable.just("89*347-87/2")
//                .flatMap(s->s.split(""))
//                .doOnNext(System.out::print)
//                .compose(FlowableTransformers.bufferUntil)
    }
}
