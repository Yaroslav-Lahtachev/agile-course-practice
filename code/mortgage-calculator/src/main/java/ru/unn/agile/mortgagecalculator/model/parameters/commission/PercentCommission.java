package ru.unn.agile.mortgagecalculator.model.parameters.commission;

import ru.unn.agile.mortgagecalculator.model.parameters.Percent;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

public class PercentCommission implements Commission {

    private Percent percent;

    public PercentCommission(final double percent) {
        Validator.checkCorrectPercent(percent);
        this.percent = new Percent(percent);
    }

    @Override
    public double calculate(final double amount) {
        return percent.getValue() * amount;
    }
}
