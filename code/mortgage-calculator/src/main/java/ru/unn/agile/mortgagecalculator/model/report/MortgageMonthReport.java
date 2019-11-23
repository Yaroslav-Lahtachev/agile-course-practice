package ru.unn.agile.mortgagecalculator.model.report;

public class MortgageMonthReport {

    private double payment;
    private double basicPayment;
    private double percentPayment;
    private double outstandingAmount;

    public MortgageMonthReport(final double payment, final double basicPayment,
                               final double percentPayment, final double currentAmount) {
        this.payment = payment;
        this.basicPayment = basicPayment;
        this.percentPayment = percentPayment;
        this.outstandingAmount = currentAmount;
    }

    public double getPayment() {
        return payment;
    }

    public double getPercentPayment() {
        return percentPayment;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

}
