package ru.unn.agile.converter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterTest {

    private final double delta = 0.001;

    @Test
    public void canConvertMeterToCentimeter() {
        LengthConverter converter = new LengthConverter(5, LengthType.METER);
        double cm = converter.convert(LengthType.CENTIMETER);
        assertEquals(500, cm, delta);
    }

    @Test
    public void canConvertMeterToKilometer() {
        LengthConverter converter = new LengthConverter(5000, LengthType.METER);
        double km = converter.convert(LengthType.KILOMETER);
        assertEquals(5, km, delta);
    }

    @Test
    public void canConvertMeterToMillimeter() {
        LengthConverter converter = new LengthConverter(2, LengthType.METER);
        double mm = converter.convert(LengthType.MILLIMETER);
        assertEquals(2000, mm, delta);
    }

    @Test
    public void canConvertMeterToMile() {
        LengthConverter converter = new LengthConverter(10000, LengthType.METER);
        double mile = converter.convert(LengthType.MILE);
        assertEquals(6.213712, mile, delta);
    }

    @Test
    public void canConvertCentimeterToMeter() {
        LengthConverter converter = new LengthConverter(250, LengthType.CENTIMETER);
        double meter = converter.convert(LengthType.METER);
        assertEquals(2.5, meter, delta);
    }

    @Test
    public void canConvertCentimeterToKilometer() {
        LengthConverter converter = new LengthConverter(35000, LengthType.CENTIMETER);
        double km = converter.convert(LengthType.KILOMETER);
        assertEquals(0.35, km, delta);
    }

    @Test
    public void canGetConverterValue() {
        LengthConverter converter = new LengthConverter(0, LengthType.METER);
        assertEquals(0, converter.getValue(), delta);
    }

    @Test
    public void canGetConverterType() {
        LengthConverter converter = new LengthConverter(0, LengthType.METER);
        assertEquals(LengthType.METER, converter.getType());
    }

    @Test
    public void canSetNewValue() {
        LengthConverter converter = new LengthConverter(0, LengthType.METER);
        converter.setValue(10);
        assertEquals(10, converter.getValue(), delta);
    }

    @Test
    public void isValueChangedAfterConvert() {
        LengthConverter converter = new LengthConverter(120, LengthType.METER);
        double newValue = converter.convert(LengthType.KILOMETER);
        assertEquals(newValue, converter.getValue(), delta);
    }

    @Test
    public void isTypeChangedAfterConvert() {
        LengthConverter converter = new LengthConverter(10, LengthType.METER);
        converter.convert(LengthType.KILOMETER);
        assertEquals(LengthType.KILOMETER, converter.getType());
    }

    @Test
    public void canConvertKilometerToYard() {
        LengthConverter converter = new LengthConverter(5, LengthType.KILOMETER);
        double yard = converter.convert(LengthType.YARD);
        assertEquals(5468.0665, yard, delta);
    }

    @Test
    public void canConvertMillimeterToInch() {
        LengthConverter converter = new LengthConverter(150, LengthType.MILLIMETER);
        double in = converter.convert(LengthType.INCH);
        assertEquals(5.90551, in, delta);
    }

    @Test
    public void canConvertMeterToFoot() {
        LengthConverter converter = new LengthConverter(50.456, LengthType.METER);
        double ft = converter.convert(LengthType.FOOT);
        assertEquals(165.5381, ft, delta);
    }

    @Test
    public void canConvertKilometerToNauticalMile() {
        LengthConverter converter = new LengthConverter(12.345, LengthType.KILOMETER);
        double mile = converter.convert(LengthType.NAUTICAL_MILE);
        assertEquals(6.6658, mile, delta);
    }

    @Test
    public void canConvertFewTimesCorrectly() {
        LengthConverter converter1 = new LengthConverter(105, LengthType.YARD);
        LengthConverter converter2 = new LengthConverter(105, LengthType.YARD);

        double mile1 = converter1.convert(LengthType.MILE);

        converter2.convert(LengthType.FOOT);
        converter2.convert(LengthType.CENTIMETER);
        double mile2 = converter2.convert(LengthType.MILE);

        assertEquals(mile1, mile2, delta);
    }

    @Test
    public void canSetMeterTypeByDefaultInit() {
        LengthConverter converter = new LengthConverter(100);
        assertEquals(LengthType.METER, converter.getType());
    }

    @Test
    public void convertedZeroValueIsZero() {
        LengthConverter converter = new LengthConverter(0);
        converter.convert(LengthType.MILE);
        assertEquals(0, converter.getValue(), delta);
    }

    @Test
    public void convertedNegativeValueIsNegative() {
        LengthConverter converter = new LengthConverter(-1000);
        converter.convert(LengthType.KILOMETER);
        assertEquals(-1, converter.getValue(), delta);
    }

    @Test
    public void canSetConverterType() {
        LengthConverter converter = new LengthConverter(10, LengthType.MILE);
        converter.setType(LengthType.YARD);
        assertEquals(LengthType.YARD, converter.getType());
    }

    @Test
    public void canSetConverterTypeWithoutValueChanging() {
        LengthConverter converter = new LengthConverter(10, LengthType.MILE);
        converter.setType(LengthType.YARD);
        assertEquals(10, converter.getValue(), delta);
    }

    @Test
    public void canConvertToTheSameType() {
        LengthConverter converter = new LengthConverter(4.278, LengthType.MILE);
        converter.convert(LengthType.MILE);
        assertEquals(4.278, converter.getValue(), delta);
    }
}
