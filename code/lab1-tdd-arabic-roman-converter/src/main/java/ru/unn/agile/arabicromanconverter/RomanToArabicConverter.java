package ru.unn.agile.arabicromanconverter;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToArabicConverter {

    private static final int[] ARABIC_NUMERALS = {1, 5, 10, 50,
            100, 500, 1000};
    private static final Character[] ROMAN_NUMERALS = {'I', 'V', 'X',
            'L', 'C', 'D', 'M'};
    private Hashtable<Character, Integer> arabicRomanMap;

    public RomanToArabicConverter() {
        arabicRomanMap = new Hashtable<>();
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            arabicRomanMap.put(ROMAN_NUMERALS[i], ARABIC_NUMERALS[i]);
        }
    }

    private boolean validateRomanNumber(final String romanNumber) {
        Pattern regexRoman = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})"
                + "(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        Matcher matcher = regexRoman.matcher(romanNumber);
        return matcher.matches();
    }

    public int convert(final String romanNumber) {
        if (!validateRomanNumber(romanNumber)) {
            throw new IllegalArgumentException(romanNumber
                    + "is not a Roman number");
        }
        int arabicNumber = 0;
        int prevSymbol = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentSymbol = arabicRomanMap.get(romanNumber.charAt(i));
            if (currentSymbol < prevSymbol) {
                arabicNumber -= currentSymbol;
            } else {
                arabicNumber += currentSymbol;
            }
            prevSymbol = currentSymbol;
        }
        return arabicNumber;
    }
}
