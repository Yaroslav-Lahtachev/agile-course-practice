package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class KonevskiyVitalyTest {

    private final double delta = 0.001;

    @Test
    public void canGetRealValue() {
        ComplexNumber z1 = new ComplexNumber(1, 0);
        assertEquals(1.0, z1.getReal(), delta);
    }

    @Test
    public void canGetImaginaryValue() {
        ComplexNumber z1 = new ComplexNumber(1, 4);
        assertEquals(4.0, z1.getImaginary(), delta);
    }

    @Test
    public void areNumbersWithDifferentPartsNotEqual() {
        ComplexNumber z1 = new ComplexNumber(2.98, 1.42);
        ComplexNumber z2 = new ComplexNumber(3.14, 2.73);
        assertNotEquals(z1, z2);
    }

    @Test
    public void canGetHashCode() {
        ComplexNumber z1 = new ComplexNumber(7, 7);
        assertFalse(z1.hashCode() < 0);
    }
}
