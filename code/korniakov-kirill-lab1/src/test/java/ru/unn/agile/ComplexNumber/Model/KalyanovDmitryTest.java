package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class KalyanovDmitryTest {
    private final double delta = 0.001;

    @Test
    public void createComplexNumEmptyConstructor() {
        ComplexNumber z1 = new ComplexNumber();
        ComplexNumber z2 = new ComplexNumber(0, 0);
        assertEquals(z2, z1);
    }

    @Test
    public void getIm() {
        ComplexNumber z1 = new ComplexNumber(342, 36483);
        assertEquals(36483, z1.getImaginary(), delta);
    }

    @Test
    public void getRe() {
        ComplexNumber z1 = new ComplexNumber(342, 36483);
        assertEquals(342, z1.getReal(), delta);
    }

    @Test
    public void canSum() {
        ComplexNumber z1 = new ComplexNumber(3, 5);
        ComplexNumber z2 = new ComplexNumber(4, 6);
        ComplexNumber z3 = new ComplexNumber(7, 11);
        assertEquals(z1.add(z2), z3);
    }

    @Test
    public void canMul() {
        ComplexNumber z1 = new ComplexNumber(3, 5);
        ComplexNumber z2 = new ComplexNumber(4, 6);
        ComplexNumber z3 = new ComplexNumber(-18, 38);
        assertEquals(z1.multiply(z2), z3);
    }

    @Test
    public void canCompareEquals() {
        ComplexNumber z1 = new ComplexNumber(3, 5);
        ComplexNumber z2 = new ComplexNumber(3, 5);
        assertTrue(z1.equals(z2));
    }

    @Test
    public void canCompareNonEquals() {
        ComplexNumber z1 = new ComplexNumber(3, 5);
        ComplexNumber z2 = new ComplexNumber(4, 6);
        assertFalse(z1.equals(z2));
    }
}
