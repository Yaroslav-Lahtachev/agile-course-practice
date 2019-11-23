package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public abstract class MortgageCalculator {

    private static final double THO_SYMBOLS_ROUND = 100.0;

    public abstract MortgageReport calculate(MortgageParameters parameters);

    protected double getCommission(final MortgageParameters parameters) {
        if (parameters.getCommission() != null) {
            return parameters.getCommission().calculate(parameters.getAmount());
        }
        return 0;
    }

    protected double getMonthlyCommission(final MortgageParameters parameters,
                                          final double currentAmount) {
        if (parameters.getMonthlyCommission() != null) {
            return parameters.getMonthlyCommission().calculate(parameters, currentAmount);
        }
        return 0;
    }

    double round(final double value) {
        return Math.round(value * THO_SYMBOLS_ROUND) / THO_SYMBOLS_ROUND;
    }
}
