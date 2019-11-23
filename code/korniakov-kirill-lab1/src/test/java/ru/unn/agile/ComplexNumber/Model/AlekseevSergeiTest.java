package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlekseevSergeiTest {

    private final double delta = 0.0001;

    @Test
    public void addingZeroDoesntChangeNumber() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);
        ComplexNumber zero = new ComplexNumber(0.0, 0.0);

        ComplexNumber sum = z.add(zero);

        assertEquals(sum, z);
    }

    @Test
    public void multiplicationByZeroChangeNumber() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);
        ComplexNumber zero = new ComplexNumber(0.0, 0.0);

        ComplexNumber mult = z.multiply(zero);

        assertEquals(mult, zero);
    }

    @Test
    public void differentNumbersNotEqual() {
        ComplexNumber z1 = new ComplexNumber(1.1, 2.3);
        ComplexNumber z2 = new ComplexNumber(5.8, 13.21);

        assertFalse(z1.equals(z2));
    }

    @Test
    public void canGetRealPart() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);

        var realPart = z.getReal();
        var expectedValue = 1.1;

        assertEquals(expectedValue, realPart, delta);
    }

    @Test
    public void canGetImaginaryPart() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);

        var imaginaryPart = z.getImaginary();
        var expectedValue = 2.3;

        assertEquals(expectedValue, imaginaryPart, delta);
    }

    @Test
    public void canAddNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(2, 3);


        ComplexNumber z = z1.add(z2);
        ComplexNumber expectedNumber = new ComplexNumber(3, 4);

        assertEquals(expectedNumber, z);
    }

    @Test
    public void canMultiplyNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(2, 3);

        ComplexNumber z = z1.multiply(z2);
        ComplexNumber expectedNumber = new ComplexNumber(-1, 5);

        assertEquals(expectedNumber, z);
    }
    @Test
    public void canFormatNumbers() {
        ComplexNumber z = new ComplexNumber(1.1, 2.35);

        String complexToString =  z.toString();
        var expectedString = "1.1 + 2.35i";

        assertEquals(expectedString, complexToString);
    }
}
