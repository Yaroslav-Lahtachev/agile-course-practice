package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TyagunovVladimirTest {
    @Test
    public void canConvertComplexNumberWithInitialValuesToString() {
        ComplexNumber number = new ComplexNumber();
        assertEquals("0.0 + 0.0i", number.toString());
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber number = new ComplexNumber(7, 10);
        System.out.println(number.toString());
        assertEquals("7.0 + 10.0i", number.toString());
    }

    @Test
    public void isNumberEqualsToItself() {
        ComplexNumber number = new ComplexNumber(7, 10);
        assertTrue(number.equals(number));
    }

    @Test
    public void canCompareWithEmptyObject() {
        ComplexNumber number = new ComplexNumber(7, 10);
        Object object = new Object();
        assertFalse(number.equals(object));
    }
}
