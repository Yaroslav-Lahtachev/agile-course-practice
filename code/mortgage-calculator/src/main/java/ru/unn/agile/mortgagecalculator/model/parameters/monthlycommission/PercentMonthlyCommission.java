package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.Percent;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

abstract class PercentMonthlyCommission implements MonthlyCommission {

    private Percent percent;

    PercentMonthlyCommission(final double percent) {
        Validator.checkCorrectPercent(percent);
        this.percent = new Percent(percent);
    }

    public Percent getPercent() {
        return percent;
    }

}
