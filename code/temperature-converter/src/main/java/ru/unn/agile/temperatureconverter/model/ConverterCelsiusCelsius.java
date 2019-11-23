package ru.unn.agile.temperatureconverter.model;

public class ConverterCelsiusCelsius implements Converter {
    @Override
    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        return new CelsiusTemperature(temperature.getValue());
    }

    @Override
    public Temperature convertFromCelsius(final CelsiusTemperature temperature) {
        return new CelsiusTemperature(temperature.getValue());
    }
}
