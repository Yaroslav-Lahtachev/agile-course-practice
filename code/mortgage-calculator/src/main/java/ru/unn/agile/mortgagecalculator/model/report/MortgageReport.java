package ru.unn.agile.mortgagecalculator.model.report;

import ru.unn.agile.mortgagecalculator.model.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class MortgageReport {

    private double amount;
    private List<MortgageMonthReport> monthsReports;
    private double finalAmount;

    public MortgageReport(final double amount) {
        this.amount = amount;
        monthsReports = new ArrayList<>();
    }

    public void add(final MortgageMonthReport monthReport) {
        monthsReports.add(monthReport);
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(final double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public MortgageMonthReport getMonthReport(final int month) {
        Validator.checkReportSize(month, monthsReports.size());
        return monthsReports.get(month - 1);
    }

    public double getOverpayment() {
        return finalAmount - amount;
    }
}
