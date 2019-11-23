package ru.unn.agile.priorityqueue.model;

import java.util.ArrayList;

public class PriorityQueue<E extends Comparable<? super E>> {
    private ArrayList<E> arr = new ArrayList<E>();

    public PriorityQueue() {
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int size() {
        return arr.size();
    }

    public void push(final E elem) {
        arr.add(elem);
        arr.sort((a, b) -> b.compareTo(a));
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        var e = arr.get(0);
        arr.remove(0);
        return e;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        var e = arr.get(0);
        return e;
    }

    public void clear() {
        arr.clear();
    }
}
