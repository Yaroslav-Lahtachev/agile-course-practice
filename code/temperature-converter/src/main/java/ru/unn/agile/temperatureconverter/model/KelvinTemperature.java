package ru.unn.agile.temperatureconverter.model;

public class KelvinTemperature extends Temperature {
    public KelvinTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public KelvinTemperature(final String value) {
        super(value);
    }

    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = 0.0;
        return absoluteZero;
    }
}
