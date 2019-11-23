package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class ShumihinSergeyTest {
    @Test
    public void canAddComplexNumbers() {
        ComplexNumber firstNumber = new ComplexNumber(1.0, 0.0);
        ComplexNumber secondNumber = new ComplexNumber(0.0, -1.0);

        ComplexNumber resultNumber = firstNumber.add(secondNumber);

        assertEquals(new ComplexNumber(1.0, -1.0), resultNumber);
    }

    @Test
    public void canInitFromString() {
        ComplexNumber number = new ComplexNumber("1.0", "0.0");

        assertNotNull(number);
    }

    @Test
    public void onSqrOfImaginaryGetMinusOneInReal() {
        ComplexNumber number = new ComplexNumber(0.0, 1);

        ComplexNumber resultNumber = number.multiply(number);

        assertEquals(new ComplexNumber(-1.0, 0.0), resultNumber);
    }
}
