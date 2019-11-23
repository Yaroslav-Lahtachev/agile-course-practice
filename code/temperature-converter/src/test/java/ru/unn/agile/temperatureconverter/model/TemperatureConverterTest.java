package ru.unn.agile.temperatureconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertCelsius0ToFahrenheit32() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        FahrenheitTemperature fahrenheit = converter.convert(celsius, FahrenheitTemperature.class);

        assertEquals(32.0, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertCelsius5ToFahrenheit41() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(5);

        FahrenheitTemperature fahrenheit = converter.convert(celsius, FahrenheitTemperature.class);

        assertEquals(41.0, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertCelsius0ToKelvin273() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        KelvinTemperature kelvin = converter.convert(celsius, KelvinTemperature.class);

        assertEquals(273.15, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertCelsius0ToNewton0() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        NewtonTemperature newton = converter.convert(celsius, NewtonTemperature.class);

        assertEquals(0, newton.getValue(), delta);
    }

    @Test
    public void canConvertCelsius33ToNewton10() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(33.0);

        NewtonTemperature newton = converter.convert(celsius, NewtonTemperature.class);

        assertEquals(10.89, newton.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit41ToCelsius5() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(41);

        CelsiusTemperature celsius = converter.convert(fahrenheit, CelsiusTemperature.class);

        assertEquals(5.0, celsius.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit10ToKelvin260() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(10);

        KelvinTemperature kelvin = converter.convert(fahrenheit, KelvinTemperature.class);

        assertEquals(260.928, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit0ToKelvin255() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(0.0);

        KelvinTemperature kelvin = converter.convert(fahrenheit, KelvinTemperature.class);

        assertEquals(255.372, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit32ToNewton0() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(32.0);

        NewtonTemperature newton = converter.convert(fahrenheit, NewtonTemperature.class);

        assertEquals(0.0, newton.getValue(), delta);
    }

    @Test
    public void canConvertKelvin0ToCelsiumAbsoluteZero() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(0.0);

        CelsiusTemperature celsius = converter.convert(kelvin, CelsiusTemperature.class);

        assertEquals(-273.15, celsius.getValue(), delta);
    }

    @Test
    public void canConvertKelvin0ToFahrenheitAbsoluteZero() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(0.0);

        FahrenheitTemperature fahrenheit = converter.convert(kelvin, FahrenheitTemperature.class);

        assertEquals(-459.67, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertKelvin455ToNewton60() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(454.97);

        NewtonTemperature newton = converter.convert(kelvin, NewtonTemperature.class);

        assertEquals(60.0, newton.getValue(), delta);
    }

    @Test
    public void canConvertNewton0ToCelsius0() {
        TemperatureConverter converter = new TemperatureConverter();
        NewtonTemperature newton = new NewtonTemperature(0.0);

        CelsiusTemperature celsius = converter.convert(newton, CelsiusTemperature.class);

        assertEquals(0.0, celsius.getValue(), delta);
    }

    @Test
    public void canConvertNewton33ToCelsius100() {
        TemperatureConverter converter = new TemperatureConverter();
        NewtonTemperature newton = new NewtonTemperature(33.0);

        CelsiusTemperature celsius = converter.convert(newton, CelsiusTemperature.class);

        assertEquals(100.0, celsius.getValue(), delta);
    }

    @Test
    public void canConvertNewton0ToFahrenheit32() {
        TemperatureConverter converter = new TemperatureConverter();
        NewtonTemperature newton = new NewtonTemperature(0.0);

        FahrenheitTemperature fahrenheit = converter.convert(newton, FahrenheitTemperature.class);

        assertEquals(32, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertNewton61ToKelvin458() {
        TemperatureConverter converter = new TemperatureConverter();
        NewtonTemperature newton = new NewtonTemperature(61.0);

        KelvinTemperature kelvin = converter.convert(newton, KelvinTemperature.class);

        assertEquals(457.998, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertCelsius0ToCelsius0() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        CelsiusTemperature celsiusTarget = converter.convert(celsius, CelsiusTemperature.class);

        assertEquals(0.0, celsiusTarget.getValue(), delta);
    }
    @Test
    public void canConvertCelsius100ToCelsius100() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(100.1);

        CelsiusTemperature celsiusTarget = converter.convert(celsius, CelsiusTemperature.class);

        assertEquals(100.1, celsiusTarget.getValue(), delta);
    }
}
