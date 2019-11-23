package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class MitrokhinNikitaTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(2, 1), z);
    }

    @Test
    public void canConvertComplexNumberToString() {
        // Arrange
        ComplexNumber z = new ComplexNumber(-1, -1);

        // Act
        String strComplex = z.toString();
        var expectedString = "-1.0 - 1.0i";

        // Assert
        assertEquals(expectedString, strComplex);
    }

    @Test
    public void canCompareEqualComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(0.0, 1.0);

        // Act
        ComplexNumber z2 = new ComplexNumber(0.0, 1.0);

        // Assert
        assertEquals(z1, z2);
    }

    @Test
    public void canMultiplyComplexNumberByZero() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(0.0, 0.0);

        // Act
        ComplexNumber z = z1.multiply(z2);
        ComplexNumber expectedComplexNumber = new ComplexNumber(0.0, 0.0);

        // Assert
        assertEquals(expectedComplexNumber, z);
    }

    @Test
    public void areNotEqualNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(2.0, 3.0);

        // Act
        boolean isEqual = z1.equals(z2);

        // Assert
        assertFalse(isEqual);
    }
}
