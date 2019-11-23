package ru.unn.agile.ComplexNumber.Model;

import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShirokikhViolettaTest {
    @Test
    public void canMultiplyNumbersWithZeroRealPart() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(0, 1);
        ComplexNumber result = z1.multiply(z2);
        assertEquals(new ComplexNumber(-1, 1), result);
    }

    @Test
    public void canMultiplyNumbersWithNegativePart() {
        ComplexNumber z1 = new ComplexNumber(-1, -4);
        ComplexNumber z2 = new ComplexNumber(2, 3);
        ComplexNumber result = z1.multiply(z2);
        assertEquals(new ComplexNumber(10, -11), result);
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber number = new ComplexNumber(2.4, 3);
        String stringComplexNumber = number.toString();
        assertEquals("2.4 + 3.0i", stringComplexNumber);
    }

    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(1, 1), z);
    }

    private final double delta = 0.001;

    @Test
    public void canCreateComplexNumberWithInitialValues() {
        ComplexNumber number = new ComplexNumber(1, 1);
        assertNotNull(number);
    }

    @Test
    public void canSetInitialRealValue() {
        ComplexNumber number = new ComplexNumber(1, 2);
        assertEquals(1.0, number.getReal(), delta);
    }

    @Test
    public void canSetInitialImaginaryValue() {
        ComplexNumber number = new ComplexNumber(1, 2);
        assertEquals(2.0, number.getImaginary(), delta);
    }

    @Test
    public void areEqualNumbersEqual() {
        ComplexNumber z1 = new ComplexNumber(3.14, 2.73);
        ComplexNumber z2 = new ComplexNumber(3.14, 2.73);
        assertTrue(z1.equals(z2));
    }

    @Test
    public void areNumbersWithDifferentRealPartNotEqual() {
        ComplexNumber z1 = new ComplexNumber(1.00, 2.73);
        ComplexNumber z2 = new ComplexNumber(3.14, 2.73);
        assertFalse(z1.equals(z2));
    }

    @Test
    public void areNumbersWithDifferentImaginaryPartNotEqual() {
        ComplexNumber z1 = new ComplexNumber(3.14, 1.00);
        ComplexNumber z2 = new ComplexNumber(3.14, 2.73);
        assertFalse(z1.equals(z2));
    }

    @Test
    public void canAddNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        ComplexNumber sum = z1.add(z2);
        assertEquals(new ComplexNumber(4, 6), sum);
    }

    @Test
    public void canAddNumbersWithNegativePart() {
        ComplexNumber z1 = new ComplexNumber(-1, 2);
        ComplexNumber z2 = new ComplexNumber(3, -4);
        ComplexNumber sum = z1.add(z2);
        assertTrue(sum.equals(new ComplexNumber(2, -2)));
    }

    @Test
    public void canFormatSumOfNumbersWithNegativePart() {
        ComplexNumber z1 = new ComplexNumber(1.2, 2.3);
        ComplexNumber z2 = new ComplexNumber(-10.4, -20.5);
        ComplexNumber sum = z1.add(z2);
        assertEquals("-9.2 - 18.2i", sum.toString());
    }

    @Test
    public void canMultiplyNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        ComplexNumber sum = z1.multiply(z2);
        assertEquals(new ComplexNumber(-5, 10), sum);
    }

    @Test
    public void canConvertStringToComplexNumber() {
        String re = "10";
        String im = "20";
        ComplexNumber z = new ComplexNumber(re, im);

        assertEquals(new ComplexNumber(10, 20), z);
    }

    @Test
    public void canConvertScientificStringToComplexNumber() {
        String re = "3.14";
        String im = "-1e3";
        ComplexNumber z = new ComplexNumber(re, im);

        assertEquals(new ComplexNumber(3.14, -1e3), z);
    }
}
