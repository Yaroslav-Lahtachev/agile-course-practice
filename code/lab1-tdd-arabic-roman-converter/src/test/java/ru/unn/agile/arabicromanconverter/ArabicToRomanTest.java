package ru.unn.agile.arabicromanconverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArabicToRomanTest {

    private String convertToRoman(final int arabicNumber) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        return converter.convert(arabicNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvert0() {
        String romanNumber = convertToRoman(0);
    }

    @Test
    public void canConvert1() {
        String romanNumber = convertToRoman(1);
        assertEquals("I", romanNumber);
    }

    @Test
    public void canConvert2() {
        String romanNumber = convertToRoman(2);
        assertEquals("II", romanNumber);
    }

    @Test
    public void canConvert3() {
        String romanNumber = convertToRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void canConvert4() {
        String romanNumber = convertToRoman(4);
        assertEquals("IV", romanNumber);
    }

    @Test
    public void canConvert5() {
        String romanNumber = convertToRoman(5);
        assertEquals("V", romanNumber);
    }

    @Test
    public void canConvert6() {
        String romanNumber = convertToRoman(6);
        assertEquals("VI", romanNumber);
    }

    @Test
    public void canConvert8() {
        String romanNumber = convertToRoman(8);
        assertEquals("VIII", romanNumber);
    }

    @Test
    public void canConvert10() {
        String romanNumber = convertToRoman(10);
        assertEquals("X", romanNumber);
    }

    @Test
    public void canConvert11() {
        String romanNumber = convertToRoman(11);
        assertEquals("XI", romanNumber);
    }

    @Test
    public void canConvert9() {
        String romanNumber = convertToRoman(9);
        assertEquals("IX", romanNumber);
    }

    @Test
    public void canConvert30() {
        String romanNumber = convertToRoman(30);
        assertEquals("XXX", romanNumber);
    }

    @Test
    public void canConvert40() {
        String romanNumber = convertToRoman(40);
        assertEquals("XL", romanNumber);
    }

    @Test
    public void canConvert50() {
        String romanNumber = convertToRoman(50);
        assertEquals("L", romanNumber);
    }

    @Test
    public void canConvert70() {
        String romanNumber = convertToRoman(70);
        assertEquals("LXX", romanNumber);
    }

    @Test
    public void canConvert100() {
        String romanNumber = convertToRoman(100);
        assertEquals("C", romanNumber);
    }

    @Test
    public void canConvert90() {
        String romanNumber = convertToRoman(90);
        assertEquals("XC", romanNumber);
    }

    @Test
    public void canConvert500() {
        String romanNumber = convertToRoman(500);
        assertEquals("D", romanNumber);
    }

    @Test
    public void canConvert400() {
        String romanNumber = convertToRoman(400);
        assertEquals("CD", romanNumber);
    }

    @Test
    public void canConvert900() {
        String romanNumber = convertToRoman(900);
        assertEquals("CM", romanNumber);
    }

    @Test
    public void canConvert1000() {
        String romanNumber = convertToRoman(1000);
        assertEquals("M", romanNumber);
    }

    @Test
    public void canConvert1974() {
        String romanNumber = convertToRoman(1974);
        assertEquals("MCMLXXIV", romanNumber);
    }

    @Test
    public void canConvert655() {
        String romanNumber = convertToRoman(655);
        assertEquals("DCLV", romanNumber);
    }

    @Test
    public void canConvert3999() {
        String romanNumber = convertToRoman(3999);
        assertEquals("MMMCMXCIX", romanNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertNegativeNumber() {
        String romanNumber = convertToRoman(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertIllegalNumber() {
        String romanNumber = convertToRoman(4000);
    }


}
