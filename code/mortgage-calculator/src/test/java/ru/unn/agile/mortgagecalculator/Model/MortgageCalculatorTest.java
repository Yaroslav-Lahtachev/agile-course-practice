package ru.unn.agile.mortgagecalculator.Model;

import org.junit.Test;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageCalculator;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageWithAnnuityPaymentsCalculator;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageWithDifferentialPaymentsCalculator;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageWithoutPaymentsCalculator;
import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.parameters.PeriodType;
import ru.unn.agile.mortgagecalculator.model.parameters.commission.FixedCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.commission.PercentCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.FixedMonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.PercentAmountMonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.PercentOutstandingMonthlyCommission;

import static org.junit.Assert.*;

public class MortgageCalculatorTest {

    private final double delta = 0.001;

    @Test
    public void canCalculateForOneYearWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 1);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(55000, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwoYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 2);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(60500, finalAmount, delta);
    }

    @Test
    public void canCalculateForThreeYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 3);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(66550, finalAmount, delta);
    }

    @Test
    public void canCalculateForFiveYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 5);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(80525.50, finalAmount, delta);
    }

    @Test
    public void canCalculateForNineYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 9);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(117897.40, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwentyFourYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageWithoutPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 24);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(492486.68, finalAmount, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForZeroYear() {
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForNegativeMounts() {
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.MONTH, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForZeroAmount() {
        MortgageParameters parameters = new MortgageParameters(0, 10, PeriodType.YEAR, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForNegativeAmount() {
        MortgageParameters parameters = new MortgageParameters(-50000, 10, PeriodType.MONTH, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForZeroPercent() {
        MortgageParameters parameters = new MortgageParameters(50000, 0, PeriodType.YEAR, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForNegativePercent() {
        MortgageParameters parameters = new MortgageParameters(50000, -10, PeriodType.MONTH, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotInitParametersForOverflowPercent() {
        MortgageParameters parameters = new MortgageParameters(50000, 130, PeriodType.MONTH, 1);
    }

    @Test
    public void canCalculateForOneYearWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 1);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(52708.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwoYearsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 2);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(55208.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForSevenYearsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 7);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(67708.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForSevenMonthsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, 7);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(51666.67, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwentySevenMonthsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, 27);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(55833.33, finalAmount, delta);
    }

    @Test
    public void canGetPaymentAtSecondMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double payment = calculator.calculate(parameters).getMonthReport(2).getPayment();

        assertEquals(5450.00, payment, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotGetPaymentAtFourteenMonthWithDifferentialPaymentsForOneYera() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, PeriodType.YEAR, 1);

        double payment = calculator.calculate(parameters).getMonthReport(14).getPayment();

        assertEquals(5450.00, payment, delta);
    }

    @Test
    public void canGetOutstandingAmountAtFifthMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double outstandingAmount =
                calculator.calculate(parameters).getMonthReport(5).getOutstandingAmount();

        assertEquals(25000.00, outstandingAmount, delta);
    }

    @Test
    public void canGetPercentPaymentAtSixMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double outstandingAmount =
                calculator.calculate(parameters).getMonthReport(6).getPercentPayment();

        assertEquals(250, outstandingAmount, delta);
    }

    @Test
    public void canGetOverpaymentWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double overpayment = calculator.calculate(parameters).getOverpayment();

        assertEquals(2750, overpayment, delta);
    }

    @Test
    public void canCalculateForOneYearWithAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, PeriodType.YEAR, 1);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(53309.27, finalAmount, delta);
    }

    @Test
    public void canGetOverpaymentWithAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double overpayment = calculator.calculate(parameters).getOverpayment();

        assertEquals(2791.04, overpayment, delta);
    }

    @Test
    public void canGetPaymentAtSixMonthWithAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double payment = calculator.calculate(parameters).getMonthReport(6).getPayment();

        assertEquals(5279.10, payment, delta);
    }

    @Test
    public void canGetOutstandingAmountAtSevenMonthWithAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double outstandingAmount =
                calculator.calculate(parameters).getMonthReport(7).getOutstandingAmount();

        assertEquals(15525.77, outstandingAmount, delta);
    }

    @Test
    public void canGetOutstandingAmountAtNineMonthWithAnnuityPaymentsForTwoYears() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, PeriodType.YEAR, 2);

        double outstandingAmount =
                calculator.calculate(parameters).getMonthReport(9).getOutstandingAmount();

        assertEquals(32633.81, outstandingAmount, delta);
    }

    @Test
    public void canCalculateWithInitialPayment() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(60000, 12, 10);
        parameters.setInitialPayment(10000);

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(52750.00, finalAmount, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCalculateWithInitialPaymentMoreThenAmount() {
        MortgageParameters parameters = new MortgageParameters(60000, 12, 10);
        parameters.setInitialPayment(99000);
    }

    @Test
    public void canCalculateWithCommission() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setCommission(new PercentCommission(10));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(57750.00, finalAmount, delta);
    }

    @Test
    public void canCalculateWithFixedCommission() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setCommission(new FixedCommission(10000));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(62750.00, finalAmount, delta);
    }

    @Test
    public void canGetOverpaymentWithCommission() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setCommission(new FixedCommission(10000));

        double overpayment = calculator.calculate(parameters).getOverpayment();

        assertEquals(12750.00, overpayment, delta);
    }

    @Test
    public void canCalculateWithFixedMonthlyCommissionDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new FixedMonthlyCommission(100));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(53750.00, finalAmount, delta);
    }

    @Test
    public void canCalculateWithFixedMonthlyCommissionAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new FixedMonthlyCommission(100));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(53791.04, finalAmount, delta);
    }

    @Test
    public void canCalculateWithPercentAmountMonthlyCommissionDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new PercentAmountMonthlyCommission(10));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(102750.00, finalAmount, delta);
    }

    @Test
    public void canCalculateWithPercentAmountMonthlyCommissionAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new PercentAmountMonthlyCommission(10));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(102791.04, finalAmount, delta);
    }

    @Test
    public void canCalculateWithPercentOutstandingMonthlyCommissionDifferentialPayments() {
        MortgageCalculator calculator = new MortgageWithDifferentialPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new PercentOutstandingMonthlyCommission(10));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(75250.00, finalAmount, delta);
    }

    @Test
    public void canCalculateWithPercentOutstandingMonthlyCommissionAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new PercentOutstandingMonthlyCommission(10));

        double finalAmount = calculator.calculate(parameters).getFinalAmount();

        assertEquals(75701.42, finalAmount, delta);
    }

    @Test
    public void canGetFourthMonthOutstandingAmountWithFixedMonthlyCommissionAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new FixedMonthlyCommission(10));

        double outstandingAmount =
                calculator.calculate(parameters).getMonthReport(4).getOutstandingAmount();

        assertEquals(30594.92, outstandingAmount, delta);
    }

    @Test
    public void canGetFourthMonthBasicPaymentWithFixedMonthlyCommissionAnnuityPayments() {
        MortgageCalculator calculator = new MortgageWithAnnuityPaymentsCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);
        parameters.setMonthlyCommission(new FixedMonthlyCommission(10));

        double basicPayment =
                calculator.calculate(parameters).getMonthReport(4).getBasicPayment();

        assertEquals(4923.92, basicPayment, delta);
    }

}
