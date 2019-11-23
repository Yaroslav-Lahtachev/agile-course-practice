package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class SizovaKsenyaTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDefaultComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber();
        double expectedRealPart = 0;
        double expectedImagPart = 0;

        // Assert
        assertEquals(complexNumber.getReal(), expectedRealPart, delta);
        assertEquals(complexNumber.getImaginary(), expectedImagPart, delta);
    }

    @Test
    public void canCreateComplexNumberWithValues() {
        ComplexNumber complexNumber = new ComplexNumber(1, 2);
        double expectedRealPart = 1;
        double expectedImagPart = 2;

        // Assert
        assertEquals(complexNumber.getReal(), expectedRealPart, delta);
        assertEquals(complexNumber.getImaginary(), expectedImagPart, delta);
    }

    @Test
    public void canCreateComplexNumberWithString() {
        ComplexNumber complexNumber = new ComplexNumber("1", "2");
        double expectedRealPart = 1;
        double expectedImagPart = 2;

        // Assert
        assertEquals(complexNumber.getReal(), expectedRealPart, delta);
        assertEquals(complexNumber.getImaginary(), expectedImagPart, delta);
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1.5, 2.5);
        ComplexNumber complexNumber2 = new ComplexNumber(2.5, 1.5);

        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);
        double expectedRealPart = 4;
        double expectedImagPart = 4;

        // Assert
        assertEquals(complexNumber3.getReal(), expectedRealPart, delta);
        assertEquals(complexNumber3.getImaginary(), expectedImagPart, delta);
    }

    @Test
    public void areEqualNumbersEqual() {
        ComplexNumber complexNumber1 = new ComplexNumber(2.71, 0.2);
        ComplexNumber complexNumber2 = new ComplexNumber(2.71, 0.2);

        // Assert
        assertTrue(complexNumber1.equals(complexNumber2));
    }

    @Test
    public void canFormatSumOfNumbersWithNegativePart() {
        ComplexNumber complexNumber1 = new ComplexNumber(2, 10);
        ComplexNumber complexNumber2 = new ComplexNumber(-5, 2);
        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);
        String expectedStringView = "-3.0 + 12.0i";

        // Assert
        assertEquals(expectedStringView, complexNumber3.toString());
    }

    @Test
    public void canMultiplyNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(2, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, 2);
        ComplexNumber complexNumber3 = complexNumber1.multiply(complexNumber2);

        // Assert
        assertEquals(new ComplexNumber(0, 5), complexNumber3);
    }
}
