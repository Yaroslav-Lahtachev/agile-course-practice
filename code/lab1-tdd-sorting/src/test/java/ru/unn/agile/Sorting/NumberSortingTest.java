package ru.unn.agile.Sorting;

import org.junit.Test;
import ru.unn.agile.sorting.api.*;
import ru.unn.agile.sorting.impl.*;

import static org.junit.Assert.*;

public class NumberSortingTest {

    @Test
    public void canCreateSortingWithoutInitialValues() {
        Sorting<Integer> numberSorting = new NumberSorting();
        assertNotNull(numberSorting);
    }

    @Test
    public void canCreateSortingWithDirection() {
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertEquals(Direction.ASC, numberSorting.getDirection());
    }

    @Test
    public void canCreateSortingWithExpression() {
        Expression<Integer> less = new NumberLessExpression();
        Sorting<Integer> numberSorting = new NumberSorting(less);
        assertEquals(less, numberSorting.getExpression());
    }

    @Test
    public void canCreateSortingWithDirectionAndExpression() {
        Expression<Integer> less = new NumberLessExpression();
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC, less);
        assertNotNull(numberSorting);
    }

    @Test
    public void canSetDirection() {
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        numberSorting.setDirection(Direction.DESC);
        assertEquals(Direction.DESC, numberSorting.getDirection());
    }

    @Test
    public void canSetExpression() {
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        Expression<Integer> less = new NumberLessExpression();
        numberSorting.setExpression(less);
        assertEquals(less, numberSorting.getExpression());
    }

    @Test
    public void canSortZeroNumber() {
        Integer[] numbers = {};
        Integer[] sortedNumbers = new Integer[]{};
        Sorting<Integer> numberSorting = new NumberSorting();
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortZeroNumberDesc() {
        Integer[] numbers = {};
        Integer[] sortedNumbers = new Integer[]{};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortOneNumberAsc() {
        Integer[] numbers = {2};
        Integer[] sortedNumbers = new Integer[]{2};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortOneNumberDesc() {
        Integer[] numbers = {2};
        Integer[] sortedNumbers = new Integer[]{2};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbers() {
        Integer[] numbers = {2, 1};
        Integer[] sortedNumbers = new Integer[]{1, 2};
        Sorting<Integer> numberSorting = new NumberSorting();
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbersDesc() {
        Integer[] numbers = {1, 2};
        Integer[] sortedNumbers = new Integer[]{2, 1};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbersAsc() {
        Integer[] numbers = {2, 1};
        Integer[] sortedNumbers = new Integer[]{1, 2};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbers() {
        Integer[] numbers = {2, 1, 3};
        Integer[] sortedNumbers = new Integer[]{1, 2, 3};
        Sorting<Integer> numberSorting = new NumberSorting();
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbersDesc() {
        Integer[] numbers = {2, 1, 3};
        Integer[] sortedNumbers = new Integer[]{3, 2, 1};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbersAsc() {
        Integer[] numbers = {2, 1, 3};
        Integer[] sortedNumbers = new Integer[]{1, 2, 3};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersDesc() {
        Integer[] numbers = {2, 1, 3, 6, 9, 7, 4, 8, 5};
        Integer[] sortedNumbers = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersAsc() {
        Integer[] numbers = {2, 1, 3, 6, 9, 7, 4, 8, 5};
        Integer[] sortedNumbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortNegativeNumbersAsc() {
        Integer[] numbers = {-2, -1, -3, -6, -9, -7, -4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{-9, -8, -7, -6, -5, -4, -3, -2, -1};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortNegativeNumbersDesc() {
        Integer[] numbers = {-2, -1, -3, -6, -9, -7, -4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortPositiveWithNegativeNumbersAsc() {
        Integer[] numbers = {-2, -1, 3, -6, 9, -7, 4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{-8, -7, -6, -5, -2, -1, 3, 4, 9};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortPositiveWithNegativeNumbersDesc() {
        Integer[] numbers = {-2, -1, 3, -6, 9, -7, 4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{9, 4, 3, -1, -2, -5, -6, -7, -8};
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersGreaterExpressionAsc() {
        Integer[] numbers = {-2, 1, 3, -6, 9, -7, 4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{9, 4, 3, 1, -2, -5, -6, -7, -8};
        Expression<Integer> numberGreaterExpression = new NumberGreaterExpression();
        Sorting<Integer> numberSorting = new NumberSorting(Direction.ASC, numberGreaterExpression);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersGreaterExpressionDesc() {
        Integer[] numbers = {-2, 1, 3, -6, 9, -7, 4, -8, -5};
        Integer[] sortedNumbers = new Integer[]{-8, -7, -6, -5, -2, 1, 3, 4, 9};
        Expression<Integer> numberGreaterExpression = new NumberGreaterExpression();
        Sorting<Integer> numberSorting = new NumberSorting(Direction.DESC, numberGreaterExpression);
        assertArrayEquals(sortedNumbers, numberSorting.sort(numbers));
    }
}
