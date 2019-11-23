package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public class MortgageWithoutPaymentsCalculator extends MortgageCalculator {

    private static final int MONTHS_IN_YEAR = 12;

    @Override
    public MortgageReport calculate(final MortgageParameters parameters) {
        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double percent = parameters.getFractionPercent();
        double finalAmount = parameters.getAmount();
        while (months >= MONTHS_IN_YEAR) {
            finalAmount = finalAmount + round(finalAmount * percent);
            months -= MONTHS_IN_YEAR;
        }

        MortgageReport report = new MortgageReport(parameters.getAmount());

        finalAmount = finalAmount + round(finalAmount * monthPercent * months);

        report.setFinalAmount(finalAmount + getCommission(parameters));

        return report;
    }

}
