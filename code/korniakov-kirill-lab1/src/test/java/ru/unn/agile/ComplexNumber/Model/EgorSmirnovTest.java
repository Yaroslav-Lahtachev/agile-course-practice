package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class EgorSmirnovTest {
    @Test
    public void canAddNumbers() {
        var number1 = new ComplexNumber(5.1, 10.1);
        var number2 = new ComplexNumber(-5.1, -10.1);

        var sum = number1.add(number2);

        assertEquals(new ComplexNumber(0.0, 0.0), sum);
    }

    @Test
    public void canMultiplyNumbers() {
        var number1 = new ComplexNumber(100500, 100500);
        var number2 = new ComplexNumber(0.0, 0.0);

        var product = number1.multiply(number2);

        assertEquals(new ComplexNumber(0, 0), product);
    }

    @Test
    public void canCompareNumbers() {
        var number1 = new ComplexNumber(100500, 100500);
        var number2 = new ComplexNumber(100500, 100500);

        var eq = number1.equals(number2);

        assertTrue(eq);
    }
}
