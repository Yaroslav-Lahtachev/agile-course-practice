package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

public class FixedMonthlyCommission implements MonthlyCommission {

    private double value;

    public FixedMonthlyCommission(final double value) {
        Validator.checkPositiveDouble(value);
        this.value = value;
    }

    @Override
    public double calculate(final MortgageParameters parameters, final double currentAmount) {
        return value;
    }
}
