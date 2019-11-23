package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;

public interface MonthlyCommission {
    double calculate(MortgageParameters parameters, double currentAmount);
}
