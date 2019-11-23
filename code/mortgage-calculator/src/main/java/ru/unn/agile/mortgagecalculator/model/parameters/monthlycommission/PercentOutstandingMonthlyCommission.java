package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;

public class PercentOutstandingMonthlyCommission extends PercentMonthlyCommission {

    public PercentOutstandingMonthlyCommission(final double percent) {
        super(percent);
    }

    @Override
    public double calculate(final MortgageParameters parameters, final double currentAmount) {
        return currentAmount * getPercent().getValue();
    }
}
