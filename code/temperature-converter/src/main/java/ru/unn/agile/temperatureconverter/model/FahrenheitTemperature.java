package ru.unn.agile.temperatureconverter.model;

public class FahrenheitTemperature extends Temperature {
    public FahrenheitTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public FahrenheitTemperature(final String value) {
        super(value);
    }

    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = -459.67;
        return absoluteZero;
    }
}
