package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class KildishevMaksimTest {

    private final double delta = 1e-3;

    @Test
    public void areComplexNumberAndStringNotEqual() {
        String string = "str";
        ComplexNumber z1 = new ComplexNumber(1, 1);
        assertFalse(z1.equals(string));
    }

    @Test
    public void areReferencesToSameObjectEquals() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = z1;
        assertTrue(z1.equals(z2));
    }

    @Test
    public void canGetReal() {
        final double expectedRealPart = 1.5;
        ComplexNumber z1 = new ComplexNumber(expectedRealPart, -1);
        assertEquals(expectedRealPart, z1.getReal(), delta);
    }

    @Test
    public void canGetImaginary() {
        final double expectedImaginaryPart = -1;
        ComplexNumber z1 = new ComplexNumber(1.5, expectedImaginaryPart);
        assertEquals(expectedImaginaryPart, z1.getImaginary(), delta);
    }
}
