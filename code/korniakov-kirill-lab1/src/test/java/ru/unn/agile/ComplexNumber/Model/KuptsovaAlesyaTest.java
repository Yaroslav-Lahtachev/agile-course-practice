package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static junit.framework.TestCase.assertEquals;

public class KuptsovaAlesyaTest {

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateComplexNumberWithIncorrectValues() {
        String re = "3.14";
        String im = "-rjfho;i";
        ComplexNumber z = new ComplexNumber(re, im);
    }

    @Test
    public void canGetRealFromComplexNumberWithRealPart() {
        double re = .14;
        double im = -13.0;
        ComplexNumber z = new ComplexNumber(re, im);
        double num = z.getReal();
        assertEquals(re, num);
    }

    @Test
    public void canGetImaginaryFromComplexNumberWithImaginaryPart() {
        double re = 3.14;
        double im = -13.0;
        ComplexNumber z = new ComplexNumber(re, im);
        double num = z.getImaginary();
        assertEquals(im, num);
    }

    @Test
    public void canMultiplyNumbersWithNegativePart() {
        ComplexNumber z1 = new ComplexNumber(-1, 4);
        ComplexNumber z2 = new ComplexNumber(-2, -3);
        ComplexNumber actualValue = z1.multiply(z2);
        ComplexNumber expectedValue = new ComplexNumber(14, -5);
        assertEquals(expectedValue, actualValue);
    }
}

