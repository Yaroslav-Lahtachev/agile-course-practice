package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class KulyginaJuliaTest {

    @Test
    public void emptyCreate() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getReal(), 0.0);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongCreateWithString() throws NumberFormatException {
        double a = 5.0;
        double b = 7.0;
        ComplexNumber z = new ComplexNumber("a", "b");
    }

    @Test()
    public void rightCreateNumbersAsStringCheckNotNull() {
        ComplexNumber z = new ComplexNumber("5.0", "7.0");

        assertNotNull(z);
    }

    @Test()
    public void createComplexNumbersAsStringCheckReal() {
        ComplexNumber z = new ComplexNumber("5.0", "7.0");

        assertEquals(5.0, z.getReal(), 0.0);
    }

    @Test()
    public void createComplexNumbersAsStringCheckImagine() {
        ComplexNumber z = new ComplexNumber("5.0", "7.0");

        assertEquals(7.0, z.getImaginary(), 0.0);
    }

    @Test()
    public void rightCreateNumbersAsNumbersCheckNotNull() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);

        assertNotNull(z);
    }

    @Test()
    public void createComplexNumbersAsNumbersCheckReal() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);

        assertEquals(5.0, z.getReal(), 0.0);
    }

    @Test()
    public void createComplexNumbersAsNumbersCheckImagine() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);

        assertEquals(7.0, z.getImaginary(), 0.0);
    }

    @Test()
    public void checkAssignment() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);
        ComplexNumber z2 = z;

        assertEquals(z, z2);
    }

    @Test()
    public void checkOperationAdd() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);
        ComplexNumber z2 = new ComplexNumber(2.3, 4.5);
        z = z.add(z2);

        assertEquals(new ComplexNumber(7.3, 11.5), z);
    }

    @Test()
    public void checkOperationMultiply() {
        ComplexNumber z = new ComplexNumber(5.0, 7.0);
        ComplexNumber z2 = new ComplexNumber(2.0, 4.5);
        z = z.multiply(z2);

        assertEquals(new ComplexNumber(-21.5, 36.5), z);
    }

    @Test()
    public void checkToString() {
        ComplexNumber z = new ComplexNumber(5.2, 7.6);
        assertEquals("5.2 + 7.6i", z.toString());
    }

    @Test()
    public void createWithNegativesNumbers() {
        ComplexNumber z = new ComplexNumber(-5.2, -7.6);
        assertEquals("-5.2 - 7.6i", z.toString());
    }

    @Test()
    public void createWithNulls() {
        ComplexNumber z = new ComplexNumber(0, 0);
        assertEquals("0.0 + 0.0i", z.toString());
    }
}
