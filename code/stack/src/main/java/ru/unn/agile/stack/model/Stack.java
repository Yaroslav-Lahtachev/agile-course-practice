package ru.unn.agile.stack.model;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(final T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null!");
        }

        list.add(item);
    }

    public T pop() {
        checkForEmptiness();

        return list.remove(list.size() - 1);
    }

    public T peek() {
        checkForEmptiness();

        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void checkForEmptiness() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is Empty!");
        }
    }
}
