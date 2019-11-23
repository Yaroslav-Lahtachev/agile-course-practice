package ru.unn.agile.temperatureconverter.model;

public interface Converter {
    CelsiusTemperature convertToCelsius(Temperature temperature);
    Temperature convertFromCelsius(CelsiusTemperature temperature);
}
