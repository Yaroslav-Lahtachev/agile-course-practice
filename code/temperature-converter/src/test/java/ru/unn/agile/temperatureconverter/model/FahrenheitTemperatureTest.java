package ru.unn.agile.temperatureconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FahrenheitTemperatureTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeFahrenheit0() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(0.0);

        assertEquals(0.0, fahrenheit.getValue(), delta);
    }

    @Test
    public void canCreateDegreeFahrenheitFromString() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature("100.01");

        assertEquals(100.01, fahrenheit.getValue(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeFahrenheitLessAbsoluteZro() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeFahrenheitLessAbsoluteZroFromString() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature("-500.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeFahrenheitFromIncorrectString() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature("abc100.0 1");
    }
}
