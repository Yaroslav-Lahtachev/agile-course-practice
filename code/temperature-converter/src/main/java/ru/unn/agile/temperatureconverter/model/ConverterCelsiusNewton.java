package ru.unn.agile.temperatureconverter.model;

class ConverterCelsiusNewton implements Converter {
    @Override
    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        final double coefficient = 100.0 / 33.0;
        return new CelsiusTemperature(coefficient * temperature.getValue());
    }

    @Override
    public Temperature convertFromCelsius(final CelsiusTemperature temperature) {
        final double coefficient = 33.0 / 100.0;
        return new NewtonTemperature(coefficient * temperature.getValue());
    }
}
