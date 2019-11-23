package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class BevzukSemenTest {
    private final double delta = 0.001;

    @Test
    public void canCreateComplexNumberByDefault() {
        ComplexNumber a = new ComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void canCreateComplexNumberWithParameters() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertNotNull(a);
    }

    @Test
    public void canSetInitialReal() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertEquals(1.0, a.getReal(), delta);
    }

    @Test
    public void canSetInitialImaginary() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertEquals(2.0, a.getImaginary(), delta);
    }

    @Test
    public void canCreateComplexNumberFromString() {
        String re = "-10.0";
        String im = "20";
        ComplexNumber a = new ComplexNumber(-10.0, 20);

        ComplexNumber b = new ComplexNumber(re, im);

        assertEquals(a, b);
    }

    @Test
    public void canHashComplexNumber() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);
        int hash;

        hash = a.hashCode();

        assertTrue(hash != 0);
    }

    @Test
    public void areDifferentComplexNumbersHashCodeNotEqual() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);
        ComplexNumber b = new ComplexNumber(2.0, 1.0);

        int aHash = a.hashCode();
        int bHash = b.hashCode();

        assertTrue(aHash != bHash);
    }

    @Test
    public void areEqualComplexNumbersHashCodeEqual() {
        ComplexNumber a = new ComplexNumber(1.0, 2.0);
        ComplexNumber b = new ComplexNumber(1.0, 2.0);

        int aHash = a.hashCode();
        int bHash = b.hashCode();

        assertEquals(aHash, bHash);
    }

    @Test
    public void areEqualComplexNumbersEqual() {
        ComplexNumber a = new ComplexNumber(10, 20.3);
        ComplexNumber b = new ComplexNumber(10, 20.3);

        assertTrue(a.equals(b));
    }

    @Test
    public void areDifferentComplexNumbersNotEqual() {
        ComplexNumber a = new ComplexNumber(40, 20.3);
        ComplexNumber b = new ComplexNumber(10, 50.3);

        assertFalse(a.equals(b));
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber a = new ComplexNumber(0, 1);
        ComplexNumber b = new ComplexNumber(2, 3);

        ComplexNumber sum = a.add(b);

        assertEquals(new ComplexNumber(2, 4), sum);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber a = new ComplexNumber(0, 1);
        ComplexNumber b = new ComplexNumber(2, 3);

        ComplexNumber sum = a.multiply(b);

        assertEquals(new ComplexNumber(-3, 2), sum);
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber a = new ComplexNumber(1.0, -2.0);

        String string = a.toString();

        assertEquals("1.0 - 2.0i", string);
    }
}
