package ru.unn.agile.priorityqueue.Model;

import org.junit.Test;
import ru.unn.agile.priorityqueue.model.PriorityQueue;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void canBeConstructed() {
        var pq = new PriorityQueue<Integer>();
        assertNotNull(pq);
    }

    @Test
    public void canHandleEmptyQueue() {
        var pq = new PriorityQueue<Integer>();
        boolean empty = pq.isEmpty();
        assertTrue(empty);
    }

    @Test
    public void canCheckNullSize() {
        var pq = new PriorityQueue<Integer>();
        var size = pq.size();
        assertEquals(0, size);
    }

    @Test
    public void canCheckNotNullSize() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);

        var size = pq.size();
        assertEquals(2, size);
    }

    @Test
    public void canPushAndPopSingleElement() {
        var pq = new PriorityQueue<Integer>();

        Integer elem1 = 1;
        pq.push(1);
        Integer elem2 = pq.pop();

        assertEquals(elem1, elem2);
    }

    @Test
    public void canHandleDecrease() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        pq.pop();

        assertEquals(1, pq.size());
    }

    @Test
    public void canPopMultipleElems() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(1);

        int v1 = pq.pop();
        int v2 = pq.pop();

        assertEquals(v1, v2);
    }

    @Test
    public void canHandleCorrectPriority() {
        var pq = new PriorityQueue<Integer>();
        var arr = new int[4];

        for (int i = 0; i < 4; ++i) {
            pq.push(i + 1);
        }

        for (int i = 0; i < 4; ++i) {
            arr[i] = pq.pop();
        }

        assertArrayEquals(new int[]{4, 3, 2, 1}, arr);
    }

    @Test
    public void canInformAboutEmptyQueue() {
        var pq = new PriorityQueue<Integer>();
        var val = pq.pop();
        assertNull(val);
    }

    @Test
    public void canPeekValues() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        int val1 = pq.peek();

        assertEquals(1, val1);
    }

    @Test
    public void canPeekWithoutSizeChanges() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        int val1 = pq.peek();
        int val2 = pq.peek();

        assertEquals(1, pq.size());
    }

    @Test
    public void canInformAboutEmptyQueueAfterPeek() {
        var pq = new PriorityQueue<Integer>();
        var val = pq.peek();
        assertNull(val);
    }

    @Test
    public void canPeekValuesWithRightPriority() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        int val1 = pq.peek();
        int val2 = pq.peek();

        assertEquals(val1, val2);
    }

    @Test
    public void canClear() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        pq.clear();

        assertEquals(0, pq.size());
    }

    @Test
    public void canClearWithRightPeek() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        pq.clear();
        var v1 = pq.peek();

        assertNull(v1);
    }

    @Test
    public void canAddSmthAfterClean() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        pq.clear();
        pq.push(3);
        int elem = pq.peek();

        assertEquals(3, elem);
    }

    @Test
    public void canWorkWithFloats() {
        var pq = new PriorityQueue<Float>();
        var arr = new float[4];

        for (int i = 0; i < 4; ++i) {
            pq.push(i + 1.0f);
        }

        for (int i = 0; i < 4; ++i) {
            arr[i] = pq.pop();
        }

        assertArrayEquals(new float[]{4, 3, 2, 1}, arr, 0);
    }

    @Test
    public void canHandleNotEmptyQueue() {
        var pq = new PriorityQueue<Integer>();
        pq.push(1);
        boolean empty = pq.isEmpty();
        assertFalse(empty);
    }
}
