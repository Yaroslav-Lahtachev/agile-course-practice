package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class KochetovaDariaTest {
    @Test
    public void complexNumberNotEqualRealNumber() {
        int number = 5;
        ComplexNumber complexNumber = new ComplexNumber(1, 2);
        assertFalse(complexNumber.equals(number));
    }

    @Test
    public void complexNumberStrEqualComplexNumberNum() {
        ComplexNumber complexNumberStr = new ComplexNumber("1", "2");
        ComplexNumber complexNumberNum = new ComplexNumber(1, 2);
        assertTrue(complexNumberStr.equals(complexNumberNum));
    }

    @Test
    public void complexNumberAddComplexNumberCorrect() {
        ComplexNumber complexNumberFirst = new ComplexNumber(4, 6);
        ComplexNumber complexNumberSecond = new ComplexNumber(1, 2);
        assertEquals(new ComplexNumber(5, 8), complexNumberFirst.add(complexNumberSecond));
    }

    @Test
    public void complexNumberMultComplexNumberCorrect() {
        ComplexNumber complexNumberFirst = new ComplexNumber(4, 6);
        ComplexNumber complexNumberSecond = new ComplexNumber(1, 2);
        assertEquals(new ComplexNumber(-8, 14), complexNumberFirst.multiply(complexNumberSecond));
    }
}
