package org.irmantas.tst;

public class testCalc {
    static SequenceCalc sequenceCalc = new SequenceCalc();

    public static void main(String[] args) {
        Double dd = sequenceCalc.sequenceOperations("89*347-87/2", 0.00);
        System.out.println(dd);
    }
}
