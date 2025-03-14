package ru.unn.agile.range.model;

import java.util.Arrays;
import java.util.Objects;

public class Range {
    private int startingElement;
    private int finiteElement;

    public Range(final String rangeString) {
        String trimRangeString = rangeString.trim();
        String[] sentences = trimRangeString.split("[\\[(,\\s\\])]+");
        startingElement = Integer.parseInt(sentences[1]);
        finiteElement = Integer.parseInt(sentences[2]);
        if (trimRangeString.startsWith("(")) {
            startingElement++;
        }
        if (trimRangeString.endsWith(")")) {
            finiteElement--;
        }
        if (startingElement > finiteElement) {
            throw new IllegalArgumentException("No numbers in the given interval!");
        }
    }

    public boolean containsSet(final int[] set) {
        for (int element : set) {
            if (!this.containsValue(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsValue(final int number) {
        return number >= startingElement && number <= finiteElement;
    }

    public int[] getAllPoints() {
        int[] points = new int[finiteElement - startingElement + 1];
        for (int i = startingElement; i <= finiteElement; i++) {
            points[i - startingElement] = i;
        }
        return points;
    }

    public boolean containRange(final Range range) {
        return this.startingElement <= range.startingElement
            && this.finiteElement >= range.finiteElement;
    }

    public int[] endPoints() {
        return new int[]{startingElement, finiteElement};
    }

    public boolean overlapsRange(final Range range) {
        long matchElements = Arrays.stream(range.getAllPoints())
                .filter(x -> Arrays.stream(this.getAllPoints()).anyMatch(y -> y == x))
                .count();
        return matchElements > 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Range range = (Range) o;
        return startingElement == range.startingElement && finiteElement == range.finiteElement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingElement, finiteElement);
    }
}
