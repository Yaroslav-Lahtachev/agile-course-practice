package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;
import static ru.unn.agile.ComplexNumber.model.ComplexNumber.Operation.ADD;
import static ru.unn.agile.ComplexNumber.model.ComplexNumber.Operation.MULTIPLY;

public class ShulpinStepanTest {

    private final double delta = 0.001;

    @Test
    public void areEqualComplexNumbersEqual() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.3, 0.7);

        assertEquals(z1, z2);
    }

    @Test
    public void areEqualComplexNumbersHaveEqualHashcode() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.3, 0.7);

        assertEquals(z1.hashCode(), z2.hashCode());
    }

    @Test
    public void areNumbersWithDifferentRealNotEqual() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.7, 0.7);

        assertNotEquals(z1, z2);
    }

    @Test
    public void areNumbersWithDifferentImaginaryNotEqual() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.3, 0.3);

        assertNotEquals(z1, z2);
    }

    @Test
    public void canCreateWithoutParameters() {
        ComplexNumber z = new ComplexNumber();

        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canCreateFromString() {
        ComplexNumber z1 = new ComplexNumber("0.3", "0.7");
        ComplexNumber z2 = new ComplexNumber(0.3, 0.7);

        assertEquals(z2, z1);
    }

    @Test
    public void canCreateFromScientificString() {
        String re = "0.3";
        String im = "-0.7E3";

        ComplexNumber z = new ComplexNumber(re, im);

        assertEquals(new ComplexNumber(0.3, -0.7E3), z);
    }

    @Test
    public void canGiveRealFromStringConstructor() {
        ComplexNumber z = new ComplexNumber("0.3", "0.7");
        double real = 0.3;

        assertEquals(real, z.getReal(), delta);
    }

    @Test
    public void canGiveImaginaryFromStringConstructor() {
        ComplexNumber z = new ComplexNumber("0.3", "0.7");
        double imaginary = 0.7;

        assertEquals(imaginary, z.getImaginary(), delta);
    }

    @Test
    public void isAddWorksRight() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.7, 0.3);

        ComplexNumber result = z1.add(z2);

        assertEquals(new ComplexNumber(1.0, 1.0), result);
    }

    @Test
    public void isAddGiveZeroForOppositeNumbers() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(-0.3, -0.7);

        ComplexNumber result = ADD.apply(z1, z2);

        assertEquals(new ComplexNumber(0, 0), result);
    }

    @Test
    public void isAddModifiesFirstNumber() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.7, 0.3);

        ComplexNumber result = z1.add(z2);

        assertEquals(new ComplexNumber(0.3, 0.7), z1);
    }

    @Test
    public void isMultiplyByOperationEnumWorksRight() {
        ComplexNumber z1 = new ComplexNumber(0.3, 0.7);
        ComplexNumber z2 = new ComplexNumber(0.7, 0.3);

        ComplexNumber result = MULTIPLY.apply(z1, z2);

        assertEquals(new ComplexNumber(0, 0.58), result);
    }

    @Test
    public void canConvertToString() {
        ComplexNumber z = new ComplexNumber(0.3, 0.7);

        assertEquals("0.3 + 0.7i", z.toString());
    }

    @Test
    public void isConvertZeroNumberToStringWrong() {
        ComplexNumber z = new ComplexNumber(0, 0);

        assertNotEquals("0", z.toString());
    }
}
