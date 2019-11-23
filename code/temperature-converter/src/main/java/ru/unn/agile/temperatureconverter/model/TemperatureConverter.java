package ru.unn.agile.temperatureconverter.model;

public class TemperatureConverter {

    private ConverterCelsiusCelsius converterCelsiusCelsius;
    private ConverterCelsiusKelvin converterCelsiusKelvin;
    private ConverterCelsiusNewton converterCelsiusNewton;
    private ConverterCelsiusFahrenheit converterCelsiusFahrenheit;

    public TemperatureConverter() {
        converterCelsiusCelsius = new ConverterCelsiusCelsius();
        converterCelsiusKelvin = new ConverterCelsiusKelvin();
        converterCelsiusNewton = new ConverterCelsiusNewton();
        converterCelsiusFahrenheit = new ConverterCelsiusFahrenheit();
    }

    @SuppressWarnings("unchecked")
    public <Template extends Temperature> Template convert(
            final Temperature temperature, final Class<Template> target) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(target.getName());
        return (Template) converterFromCelsius.convertFromCelsius(celsius);
    }

    private Converter getConverter(final String className) throws IllegalStateException {
        if (className.equals(CelsiusTemperature.class.getName())) {
            return converterCelsiusCelsius;
        } else if (className.equals(KelvinTemperature.class.getName())) {
            return converterCelsiusKelvin;
        } else if (className.equals(NewtonTemperature.class.getName())) {
            return converterCelsiusNewton;
        } else if (className.equals(FahrenheitTemperature.class.getName())) {
            return converterCelsiusFahrenheit;
        } else {
            throw new IllegalStateException("Unexpected value: " + className);
        }
    }
}
