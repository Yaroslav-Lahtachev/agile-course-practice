package ru.unn.agile.sorting.api;

import java.util.Objects;

public abstract class Sorting<T> {

    private Direction direction;

    private Expression<T> expression;

    public Sorting(final Direction direction, final Expression<T> expression) {
        this.direction = direction;
        this.expression = expression;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setExpression(final Expression<T> expression) {
        this.expression = expression;
    }

    public Expression<T> getExpression() {
        return expression;
    }

    public abstract T[] sort(T[] objects);

    @Override
    public String toString() {
        return "Sorting{"
                + "direction="
                + direction
                + ", expression="
                + expression
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sorting<?> sorting = (Sorting<?>) o;
        return direction == sorting.direction
                && expression.equals(sorting.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, expression);
    }
}
