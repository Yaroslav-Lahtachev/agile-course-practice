package ru.unn.agile.temperatureconverter.model;

class ConverterCelsiusFahrenheit implements Converter {
    @Override
    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        final double coefficient = 5.0 / 9.0;
        final double shift = 32.0;
        return new CelsiusTemperature(coefficient * (temperature.getValue() - shift));
    }

    @Override
    public Temperature convertFromCelsius(final CelsiusTemperature temperature) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return new FahrenheitTemperature(coefficient * temperature.getValue() + shift);
    }
}
