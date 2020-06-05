package org.irmantas.tst;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SequenceCalcTest {
    SequenceCalc calc = new SequenceCalc();
    @Test
    void sequenceOperations() {
        Assert.assertEquals(Optional.of(6.00), Optional.ofNullable(calc.sequenceOperations("2+4", 0.00)));
    }

    @Test
    void operationSequenceRezultPrev() {
        Assert.assertEquals(Optional.of(4.00),Optional.ofNullable(calc.operationSequenceRezultPrev(Arrays.asList("2","8","2"),Arrays.asList("/","*","/"),2.00)));

    }

    @Test
    void operationSequenceRezult() {
        Assert.assertEquals(Optional.of(8.00),Optional.ofNullable(calc.operationSequenceRezult(Arrays.asList("2","8","2"),Arrays.asList("*","/"))));
    }

    @Test
    void red() {
        Assert.assertEquals(Optional.of(160.00),Optional.ofNullable(calc.red(16.00,"*",10.00)));
    }
}