package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageMonthReport;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public class MortgageWithAnnuityPaymentsCalculator extends MortgageCalculator {

    @Override
    public MortgageReport calculate(final MortgageParameters parameters) {
        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double annuityPayment = getAnnuityPayment(parameters.getAmount(), monthPercent, months);
        double currentAmount = parameters.getAmount();
        double finalAmount = 0;

        MortgageReport report = new MortgageReport(parameters.getAmount());

        double percentPayment;
        double basicPayment;
        double paymentWithCommission;

        while (months > 0) {
            percentPayment = currentAmount * monthPercent;
            basicPayment = annuityPayment - percentPayment;
            currentAmount -= basicPayment;
            paymentWithCommission =
                    annuityPayment + getMonthlyCommission(parameters, currentAmount);
            MortgageMonthReport monthReport =
                    new MortgageMonthReport(round(paymentWithCommission), round(basicPayment),
                            round(percentPayment), round(currentAmount));
            report.add(monthReport);

            finalAmount += paymentWithCommission;

            months--;
        }

        report.setFinalAmount(round(finalAmount) + getCommission(parameters));

        return report;
    }

    private double getAnnuityPayment(final double amount, final double percent, final int months) {
        return amount * (percent + percent / (Math.pow(1 + percent, months) - 1));
    }

}
