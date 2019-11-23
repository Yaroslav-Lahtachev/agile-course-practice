package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class IuferevKirillTest {

    private final double delta = 0.001;

    @Test
    public void areNumberIsNotEqualComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        var numberValueToCompare = 24;
        assertFalse(complexNumber.equals(numberValueToCompare));
    }

    @Test
    public void canFormatToString() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        var expectedString = "2.4 + 4.4i";
        assertEquals(expectedString, complexNumber.toString());
    }

    @Test
    public void canGetImaginaryPart() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        var expectedImaginaryPart = 4.4;
        assertTrue(complexNumber.getImaginary() == expectedImaginaryPart);
    }

    @Test
    public void canGetRealPart() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        var expectedRealPart = 2.4;
        assertEquals(expectedRealPart, complexNumber.getReal(), delta);
    }
}
