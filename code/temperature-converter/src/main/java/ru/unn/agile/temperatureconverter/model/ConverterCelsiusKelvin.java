package ru.unn.agile.temperatureconverter.model;

class ConverterCelsiusKelvin implements Converter {
    @Override
    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        final double shift = 273.15;
        return new CelsiusTemperature(temperature.getValue() - shift);
    }

    @Override
    public Temperature convertFromCelsius(final CelsiusTemperature temperature) {
        final double shift = 273.15;
        return new KelvinTemperature(temperature.getValue() + shift);
    }
}
