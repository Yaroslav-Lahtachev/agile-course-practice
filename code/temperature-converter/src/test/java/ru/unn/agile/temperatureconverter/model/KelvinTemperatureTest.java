package ru.unn.agile.temperatureconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KelvinTemperatureTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeKelvin0() {
        KelvinTemperature kelvin = new KelvinTemperature(0.0);

        assertEquals(0.0, kelvin.getValue(), delta);
    }

    @Test
    public void canCreateDegreeKelvinFromString() {
        KelvinTemperature kelvin = new KelvinTemperature("100.01");

        assertEquals(100.01, kelvin.getValue(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeKelvinLessAbsoluteZro() {
        KelvinTemperature kelvin = new KelvinTemperature(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeKelvinLessAbsoluteZroFromString() {
        KelvinTemperature kelvin = new KelvinTemperature("-500.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeKelvinFromIncorrectString() {
        KelvinTemperature kelvin = new KelvinTemperature("abc100.0 1");
    }
}
