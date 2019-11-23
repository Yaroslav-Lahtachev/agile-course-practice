package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;

public class PercentAmountMonthlyCommission extends PercentMonthlyCommission {

    public PercentAmountMonthlyCommission(final double percent) {
        super(percent);
    }

    @Override
    public double calculate(final MortgageParameters parameters, final double currentAmount) {
        return parameters.getAmount() * getPercent().getValue();
    }
}
