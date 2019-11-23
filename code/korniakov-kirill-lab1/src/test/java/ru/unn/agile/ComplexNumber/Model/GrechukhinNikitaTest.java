package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class GrechukhinNikitaTest {

    private final double delta = 1e-3;

    @Test
    public void canCreateWithoutParameters() {
        var complexNumber = new ComplexNumber();
        assertNotNull(complexNumber);
    }

    @Test
    public void canCreateWithDoubleParameters() {
        var complexNumber = new ComplexNumber(1.3, 2.9);
        assertNotNull(complexNumber);
    }

    @Test
    public void canCreateWithStringParameters() {
        var complexNumber = new ComplexNumber("2.11", "9.4");
        assertNotNull(complexNumber);
    }

    @Test
    public void canGetRealPart() {
        var expectedRealPart = 10.2;
        var complexNumber = new ComplexNumber(expectedRealPart, 93.4);
        assertEquals(expectedRealPart, complexNumber.getReal(), delta);
    }

    @Test
    public void canGetImaginaryPart() {
        var expectedImaginaryPart = 0.1;
        var complexNumber = new ComplexNumber(0.0, expectedImaginaryPart);
        assertEquals(expectedImaginaryPart, complexNumber.getImaginary(), delta);
    }

    @Test(expected = NumberFormatException.class)
    public void canThrowWithIncorrectString() {
        new ComplexNumber("Throw", "Exception");
    }
}
