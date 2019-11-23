package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NesterovAlexanderTest {
    private final double delta = 1e-15;

    @Test
    public void isRightNormComplexNumber() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 6);
        ComplexNumber z1Inv = new ComplexNumber(2, -6);
        double normZ = Math.pow(2, 2) + Math.pow(6, 2);

        // Act
        ComplexNumber z = z1.multiply(z1Inv);

        // Assert
        assertEquals(new ComplexNumber(normZ, 0), z);
    }

    @Test
    public void isRightRelativeMathRelation() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2.22, 4.67);
        ComplexNumber z1Inv = new ComplexNumber(2.22, -4.67);

        // Act
        ComplexNumber z = z1.add(z1Inv);

        // Assert
        assertEquals(4.44, z.getReal() + z.getImaginary(), delta);
    }

    public double getArg(final ComplexNumber num) {
        double normNum = Math.sqrt(Math.pow(num.getReal(), 2) + Math.pow(num.getImaginary(), 2));
        return Math.asin(num.getImaginary() / normNum);
    }

    @Test
    public void argNumberIsHalfPI() {
        // Arrange
        ComplexNumber z = new ComplexNumber(0, 1);

        // Act
        double res = getArg(z);

        // Assert
        assertEquals(res, Math.PI / 2, delta);
    }

    @Test
    public void argNumberIsZero() {
        // Arrange
        ComplexNumber z = new ComplexNumber(1, 0);

        // Act
        double res = getArg(z);

        // Assert
        assertEquals(res, 0, delta);
    }

    @Test
    public void argNumberIsQuarterPI() {
        // Arrange
        ComplexNumber z = new ComplexNumber(Math.sqrt(2) / 2, Math.sqrt(2) / 2);

        // Act
        double res = getArg(z);

        // Assert
        assertEquals(res, Math.PI / 4, delta);
    }

    @Test
    public void isRightArgMathRelation() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(5.78, 3.87);
        ComplexNumber z2 = new ComplexNumber(9.34, -0.87);

        // Act
        double res1 = getArg(z1.multiply(z2));
        double res2 = getArg(z1) + getArg(z2);

        // Assert
        assertEquals(res1, res2, delta);
    }
}
