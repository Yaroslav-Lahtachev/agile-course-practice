package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class MironovaAnnaTest {
    @Test
    public void canCreateComplexNumberWithoutArguments() {
        ComplexNumber z = new ComplexNumber();

        assertNotNull(z);
    }

    @Test
    public void canCreateComplexNumberWithStringArguments() {
        final String re = "1.0";
        final String im = "1.0";

        ComplexNumber z = new ComplexNumber(re, im);

        assertNotNull(z);
    }

    @Test
    public void canCompareEqualComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 0.0);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void canCompareNotEqualComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        assertFalse(z1.equals(z2));
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(3.0, 3.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);
        ComplexNumber expected = new ComplexNumber(0.0, 6.0);

        ComplexNumber real = z1.multiply(z2);

        assertEquals(expected, real);
    }
}
