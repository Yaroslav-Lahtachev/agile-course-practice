package ru.unn.agile.temperatureconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CelsiusTemperatureTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeCelsius0() {
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        assertEquals(0.0, celsius.getValue(), delta);
    }

    @Test
    public void canCreateDegreeCelsiusFromString() {
        CelsiusTemperature celsius = new CelsiusTemperature("100.01");

        assertEquals(100.01, celsius.getValue(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZro() {
        CelsiusTemperature celsius = new CelsiusTemperature(-274.15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZroFromString() {
        CelsiusTemperature celsius = new CelsiusTemperature("-300.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeCelsiusFromIncorrectString() {
        CelsiusTemperature celsius = new CelsiusTemperature("abc100.0 1");
    }
}
