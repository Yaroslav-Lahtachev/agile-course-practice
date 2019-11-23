package ru.unn.agile.arabicromanconverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToArabicTest {

    private int convertToArabic(final String romanNumber) {
        RomanToArabicConverter converter = new RomanToArabicConverter();
        int arabicNumber = converter.convert(romanNumber);
        return arabicNumber;
    }

    @Test
    public void canConvertTo1() {
        int arabicNumber = convertToArabic("I");
        assertEquals(1, arabicNumber);
    }

    @Test
    public void canConvertTo2() {
        int arabicNumber = convertToArabic("II");
        assertEquals(2, arabicNumber);
    }

    @Test
    public void canConvertTo3() {
        int arabicNumber = convertToArabic("III");
        assertEquals(3, arabicNumber);
    }

    @Test
    public void canConvertTo4() {
        int arabicNumber = convertToArabic("IV");
        assertEquals(4, arabicNumber);
    }

    @Test
    public void canConvertTo5() {
        int arabicNumber = convertToArabic("V");
        assertEquals(5, arabicNumber);
    }

    @Test
    public void canConvertTo6() {
        int arabicNumber = convertToArabic("VI");
        assertEquals(6, arabicNumber);
    }

    @Test
    public void canConvertTo10() {
        int arabicNumber = convertToArabic("X");
        assertEquals(10, arabicNumber);
    }

    @Test
    public void canConvertTo9() {
        int arabicNumber = convertToArabic("IX");
        assertEquals(9, arabicNumber);
    }

    @Test
    public void canConvertTo11() {
        int arabicNumber = convertToArabic("XI");
        assertEquals(11, arabicNumber);
    }

    @Test
    public void canConvertTo30() {
        int arabicNumber = convertToArabic("XXX");
        assertEquals(30, arabicNumber);
    }

    @Test
    public void canConvertTo40() {
        int arabicNumber = convertToArabic("XL");
        assertEquals(40, arabicNumber);
    }

    @Test
    public void canConvertTo50() {
        int arabicNumber = convertToArabic("L");
        assertEquals(50, arabicNumber);
    }

    @Test
    public void canConvertTo100() {
        int arabicNumber = convertToArabic("C");
        assertEquals(100, arabicNumber);
    }

    @Test
    public void canConvertTo500() {
        int arabicNumber = convertToArabic("D");
        assertEquals(500, arabicNumber);
    }

    @Test
    public void canConvertTo1000() {
        int arabicNumber = convertToArabic("M");
        assertEquals(1000, arabicNumber);
    }

    @Test
    public void canConvertTo99() {
        int arabicNumber = convertToArabic("XCIX");
        assertEquals(99, arabicNumber);
    }

    @Test
    public void canConvertTo944() {
        int arabicNumber = convertToArabic("CMXLIV");
        assertEquals(944, arabicNumber);
    }

    @Test
    public void canConvertTo444() {
        int arabicNumber = convertToArabic("CDXLIV");
        assertEquals(444, arabicNumber);
    }

    @Test
    public void canConvertTo3999() {
        int arabicNumber = convertToArabic("MMMCMXCIX");
        assertEquals(3999, arabicNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertTo4000() {
        int arabicNumber = convertToArabic("MMMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertWrongRomanValue() {
        int arabicNumber = convertToArabic("IIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertIllegalValue() {
        int arabicNumber = convertToArabic("BUGAGASHENKA");
    }
}
