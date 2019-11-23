package ru.unn.agile.temperatureconverter.model;

public class CelsiusTemperature extends Temperature {
    public CelsiusTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public CelsiusTemperature(final String value) {
        super(value);
    }

    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = -273.15;
        return absoluteZero;
    }
}
