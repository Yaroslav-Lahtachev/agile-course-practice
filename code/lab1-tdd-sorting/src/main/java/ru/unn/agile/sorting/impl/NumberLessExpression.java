package ru.unn.agile.sorting.impl;

import ru.unn.agile.sorting.api.Expression;

public class NumberLessExpression extends Expression<Integer> {

    @Override
    public boolean compare(final Integer number1, final Integer number2) {
        return number1 < number2;
    }
}
