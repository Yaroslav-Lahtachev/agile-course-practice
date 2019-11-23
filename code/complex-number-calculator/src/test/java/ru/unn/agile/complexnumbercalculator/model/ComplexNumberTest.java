package ru.unn.agile.complexnumbercalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    @Test
    public void canCreateComplexNumberWithParametersNotNull() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, 6.0);

        assertNotNull(a);
    }

    @Test
    public void canCreateComplexNumberWithParametersCheckRe() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, 6.0);

        assertEquals(5.0, a.getRe(), 0.0);
    }

    @Test
    public void canCreateComplexNumberWithParametersCheckIm() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, 6.0);

        assertEquals(6.0, a.getIm(), 0.0);
    }

    @Test
    public void canCreateComplexNumberWithNegativeParametersCheckRe() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(-5.0, 6.0);

        assertEquals(-5.0, a.getRe(), 0.0);
    }

    @Test
    public void canCreateComplexNumberWithNegativeParametersCheckIm() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -6.0);

        assertEquals(-6.0, a.getIm(), 0.0);
    }

    @Test
    public void canEqualTwoComplexNumbers() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -6.0);
        ComplexNumber b = ComplexNumber.createAlgebraicForm(5.0, -6.0);

        assertEquals(a, b);
    }

    @Test
    public void cantEqualTwoComplexNumbers() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -6.0);
        ComplexNumber b = ComplexNumber.createAlgebraicForm(-5.0, -6.0);

        assertNotEquals(a, b);
    }

    @Test
    public void canEqualTwoComplexNumbersWithOperand() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(a);

        assertTrue(a.equals(b));
    }

    @Test
    public void canEqualHashCodeOfTwoComplexNumbers() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -6.0);
        ComplexNumber b = ComplexNumber.createAlgebraicForm(5.0, -6.0);

        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, 2.0);

        String string = a.toString();

        assertEquals("5.0 + 2.0i", string);
    }

    @Test
    public void canConvertComplexNumberToStringWithNegative() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(5.0, -2.0);

        String string = a.toString();

        assertEquals("5.0 - 2.0i", string);
    }

    @Test
    public void canConvertComplexNumberToStringWithNull() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(0.0, -2.0);

        String string = a.toString();

        assertEquals("0.0 - 2.0i", string);
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormCheckModule() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(1.0, -Math.sqrt(3));

        assertEquals(2, a.getModule(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormCheckArgument() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(1.0, -Math.sqrt(3));

        assertEquals(-Math.PI / 3, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormInBoundary() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(-1.0, 0.0);

        assertEquals(Math.PI, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormWithoutIm() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(1.0, 0.0);

        assertEquals(0.0, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormWithoutImNegRe() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(-1.0, 0.0);

        assertEquals(Math.PI, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormWithoutRe() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(0.0, 1.0);

        assertEquals(Math.PI / 2, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canConvertComplexNumberToTrigonometricFormWithoutReNegIm() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(0.0, -1.0);

        assertEquals(-Math.PI / 2, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canGetModuleNot0() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(1, 1);

        assertEquals(Math.sqrt(2), a.getModule(), a.getAccuracy());
    }


    @Test
    public void canGetArgumentNot0() {
        ComplexNumber a = ComplexNumber.createAlgebraicForm(1, 1);

        assertEquals(Math.PI / 4, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canCreateTrigonometricFormArgument() {
        ComplexNumber a = ComplexNumber.createTrigonometricForm(0.0, Math.PI);

        assertEquals(Math.PI, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canCreateTrigonometricFormRe() {
        ComplexNumber a = ComplexNumber.createTrigonometricForm(1.0, Math.PI / 3);

        assertEquals(Math.cos(Math.PI / 3), a.getRe(), a.getAccuracy());
    }

    @Test
    public void canCreateTrigonometricFormIm() {
        ComplexNumber a = ComplexNumber.createTrigonometricForm(1.0, Math.PI / 3);

        assertEquals(Math.sin(Math.PI / 3), a.getIm(), a.getAccuracy());
    }


}
