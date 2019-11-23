package ru.unn.agile.temperatureconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewtonTemperatureTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeNewton0() {
        NewtonTemperature newton = new NewtonTemperature(0.0);

        assertEquals(0.0, newton.getValue(), delta);
    }

    @Test
    public void canCreateDegreeNewtonFromString() {
        NewtonTemperature newton = new NewtonTemperature("100.01");

        assertEquals(100.01, newton.getValue(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeNewtonLessAbsoluteZro() {
        NewtonTemperature newton = new NewtonTemperature(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeNewtonLessAbsoluteZroFromString() {
        NewtonTemperature newton = new NewtonTemperature("-500.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeNewtonFromIncorrectString() {
        NewtonTemperature newton = new NewtonTemperature("abc100.0 1");
    }
}
