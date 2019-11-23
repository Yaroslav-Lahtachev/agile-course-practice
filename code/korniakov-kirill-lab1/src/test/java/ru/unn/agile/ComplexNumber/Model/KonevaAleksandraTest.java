package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class KonevaAleksandraTest {
    @Test
    public void canAddIdentityElement() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        ComplexNumber sum = z1.add(z2);

        assertEquals(z1, sum);
    }

    @Test
    public void canAddInverseElement() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(-1, -2);

        ComplexNumber sum = z1.add(z2);

        assertEquals(new ComplexNumber(0, 0), sum);
    }

    @Test
    public void addIsCommutative() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);

        ComplexNumber sum1 = z1.add(z2);
        ComplexNumber sum2 = z2.add(z1);

        assertEquals(sum1, sum2);
    }

    @Test
    public void canMultiplyIdentityElement() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(1, 0);

        ComplexNumber sum = z1.multiply(z2);

        assertEquals(z1, sum);
    }

    @Test
    public void canMultiplyInverseElement() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(0, 0);
        ComplexNumber sum = z1.multiply(z2);
        assertEquals(new ComplexNumber(0, 0), sum);
    }

    @Test
    public void multiplyIsCommutative() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);

        ComplexNumber mult1 = z1.multiply(z2);
        ComplexNumber mult2 = z2.multiply(z1);

        assertEquals(mult1, mult2);
    }
}
