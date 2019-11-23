package ru.unn.agile.stack.Model;

import org.junit.Test;
import ru.unn.agile.stack.model.Stack;

import static org.junit.Assert.*;

public class StackTest {

    @Test(expected = Test.None.class)
    public void canPushIntegerToStack() {
        Stack<Integer> stack = new Stack<>();
        int valueToAdd = 5;

        stack.push(valueToAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowWhenPushNullElementToStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(null);
    }

    @Test
    public void canPopItemFromStack() {
        Stack<Integer> stack = new Stack<>();
        Integer valueToAdd = 5;

        stack.push(valueToAdd);
        Integer actualItem = stack.pop();

        assertEquals(valueToAdd, actualItem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canThrowWhenPopFromEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        stack.pop();
    }

    @Test
    public void canPeekItemFromStack() {
        Stack<Integer> stack = new Stack<>();
        Integer valueToAdd = 5;

        stack.push(valueToAdd);
        Integer actualItem = stack.peek();

        assertEquals(valueToAdd, actualItem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canThrowWhenPeekFromEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        stack.peek();
    }

    @Test
    public void isStackWithoutItemsEmpty() {
        Stack<Integer> stack = new Stack<>();

        boolean isStackEmpty = stack.isEmpty();

        assertTrue(isStackEmpty);
    }

    @Test
    public void isStackWithItemsNotEmpty() {
        Stack<Integer> stack = new Stack<>();
        Integer valueToAdd = 5;

        stack.push(valueToAdd);
        boolean isStackEmpty = stack.isEmpty();

        assertFalse(isStackEmpty);
    }

    @Test
    public void isPopMethodTakeLastAddedToStack() {
        Stack<Integer> stack = new Stack<>();
        Integer firstValueToAdd = 5;
        Integer secondValueToAdd = 6;

        stack.push(firstValueToAdd);
        stack.push(secondValueToAdd);
        Integer actualItem = stack.pop();

        assertEquals(secondValueToAdd, actualItem);
    }

    @Test
    public void isPeekMethodTakeLastAddedToStack() {
        Stack<Integer> stack = new Stack<>();
        Integer firstValueToAdd = 5;
        Integer secondValueToAdd = 6;

        stack.push(firstValueToAdd);
        stack.push(secondValueToAdd);
        Integer actualItem = stack.peek();

        assertEquals(secondValueToAdd, actualItem);
    }

    @Test
    public void isCanPopMoreThenOne() {
        Stack<Integer> stack = new Stack<>();
        Integer firstValueToAdd = 5;
        Integer secondValueToAdd = 6;

        stack.push(firstValueToAdd);
        stack.push(secondValueToAdd);
        stack.pop();
        stack.pop();
        boolean isStackEmpty = stack.isEmpty();

        assertTrue(isStackEmpty);
    }
}
