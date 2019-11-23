package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static ru.unn.agile.ComplexNumber.model.ComplexNumber.Operation;

import static org.junit.Assert.*;


public class LapinArtemTest {
    private final double delta = 0.001;

    @Test
    public void getRealWorksCorrect() {
        double real = 1.0;
        ComplexNumber cn = new ComplexNumber(real, 0.0);
        assertEquals(real, cn.getReal(), delta);
    }

    @Test
    public void getImagineWorksCorrect() {
        double imaginary = 1.0;
        ComplexNumber cn = new ComplexNumber(1.0, imaginary);
        assertEquals(imaginary, cn.getImaginary(), delta);
    }

    @Test
    public void canReturnHashCode() {
        ComplexNumber cn = new ComplexNumber(0.0, 0.0);
        assertTrue((cn.hashCode() >= 0));
    }

    @Test
    public void toStringWorksCorrect() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        assertEquals("1.0 + 1.0i", cn.toString());
    }

    @Test
    public void toStringWithNegativePartsWorksCorrect() {
        ComplexNumber cn = new ComplexNumber(-1.0, -1.0);
        assertEquals("-1.0 - 1.0i", cn.toString());
    }

    @Test
    public void toStringWithZeroNumberWorksCorrect() {
        ComplexNumber cn = new ComplexNumber(0.0, 0.0);
        assertEquals("0.0 + 0.0i", cn.toString());
    }

    @Test
    public void canCreateWithoutParameters() {
        ComplexNumber cn = new ComplexNumber();
        assertEquals(new ComplexNumber(0.0, 0.0), cn);
    }

    @Test
    public void canCreateWithStringParameters() {
        ComplexNumber cn = new ComplexNumber("1.0", "-1.0");
        assertEquals(new ComplexNumber(1.0, -1.0), cn);
    }

    @Test
    public void canCreateWithScientificStringParameters() {
        String re = "3.14";
        String im = "-1e4";
        ComplexNumber z = new ComplexNumber(re, im);

        assertEquals(new ComplexNumber(3.14, -1e4), z);
    }

    @Test
    public void addWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(0.0, 1.1);

        ComplexNumber addResult = Operation.ADD.apply(cn1, cn2);

        assertEquals(new ComplexNumber(1.0, 2.1), addResult);
    }

    @Test
    public void addZeroNumberWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber addResult = cn1.add(cn2);

        assertEquals(new ComplexNumber(1.0, 1.0), addResult);
    }

    @Test
    public void addNegativeNumberWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(-2.0, -2.0);

        ComplexNumber addResult = cn1.add(cn2);

        assertEquals(new ComplexNumber(-1.0, -1.0), addResult);
    }

    @Test
    public void multiplyWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(0.0, 1.0);

        ComplexNumber multResult = Operation.MULTIPLY.apply(cn1, cn2);

        assertEquals(new ComplexNumber(-1.0, 1.0), multResult);
    }

    @Test
    public void multiplyWithZeroNumberWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(0.0, 0.0);

        ComplexNumber multResult = cn1.multiply(cn2);

        assertEquals(new ComplexNumber(0.0, 0.0), multResult);
    }

    @Test
    public void multiplyWithNegativeNumberWorksCorrect() {

        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(-2.0, -2.0);

        ComplexNumber multResult = cn1.multiply(cn2);

        assertEquals(new ComplexNumber(0.0, -4.0), multResult);
    }

    @Test
    public void areEqualNumbersEqual() {
        ComplexNumber cn1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(1.0, 1.0);

        assertEquals(cn1, cn2);
    }

    @Test
    public void areNotEqualNumbersNotEqual() {
        ComplexNumber cn1 = new ComplexNumber(-2.0, -2.0);
        ComplexNumber cn2 = new ComplexNumber(1.0, 1.0);

        assertNotEquals(cn1, cn2);
    }

    @Test
    public void areNumbersWithDifferentImaginaryNotEqual() {
        ComplexNumber cn1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber cn2 = new ComplexNumber(1.0, 1.0);

        assertNotEquals(cn1, cn2);
    }

    @Test
    public void areNumbersWithDifferentRealNotEqual() {
        ComplexNumber cn1 = new ComplexNumber(0.0, 1.0);
        ComplexNumber cn2 = new ComplexNumber(1.0, 1.0);

        assertNotEquals(cn1, cn2);
    }
}

