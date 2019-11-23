package ru.unn.agile.mortgagecalculator.model.parameters;

public class Percent {

    private static final double FRACTION_OF_HUNDRED = 0.01;

    private double percent;
    private double fractionPercent;

    public Percent(final double percent) {
        this.percent = percent;
        this.fractionPercent = convertToFractionPercent(percent);
    }

    public double getValue() {
        return fractionPercent;
    }

    private double convertToFractionPercent(final double percent) {
        return percent * FRACTION_OF_HUNDRED;
    }

}
