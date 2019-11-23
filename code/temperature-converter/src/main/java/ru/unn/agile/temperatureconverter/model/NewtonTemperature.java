package ru.unn.agile.temperatureconverter.model;

public class NewtonTemperature extends Temperature {
    public NewtonTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public NewtonTemperature(final String value) {
        super(value);
    }

    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = -90.14;
        return absoluteZero;
    }
}
