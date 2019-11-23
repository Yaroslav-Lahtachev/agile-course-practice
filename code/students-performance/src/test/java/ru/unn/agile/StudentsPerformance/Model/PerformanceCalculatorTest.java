package ru.unn.agile.StudentsPerformance.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PerformanceCalculatorTest {

    private static final double COMPARE_DELTA = 0.1;

    @Test
    public void canCreateCalculator() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertNotNull(calculator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCalculatorIfStudentsAreNull() {
        List<Student> students = null;
        new PerformanceCalculator(students);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCalculatorIfStudentsAreEmpty() {
        List<Student> students = new ArrayList<>();
        new PerformanceCalculator(students);
    }

    @Test
    public void canGetExcellentStudentsCountIfExist() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(1, calculator.getExcellentStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetExcellentStudentsCountIfNotExist() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 3, 2, 5, 5, 4))),
                        new Student(new ArrayList<>(List.of(5, 3, 5, 2, 5))),
                        new Student(new ArrayList<>(List.of(3, 2, 4, 5, 3, 5))),
                        new Student(new ArrayList<>(List.of(5, 4, 5))),
                        new Student(new ArrayList<>(List.of(3, 4, 4, 2, 4, 3)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0, calculator.getExcellentStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetGoodStudentsCountIfExist() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(1, calculator.getGoodStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetGoodStudentsCountIfNotExist() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 3, 2, 5, 2, 4))),
                        new Student(new ArrayList<>(List.of(5, 3, 5, 2, 4, 5))),
                        new Student(new ArrayList<>(List.of(5, 2, 4, 5, 2, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 5))),
                        new Student(new ArrayList<>(List.of(3, 5, 4, 4, 5, 3)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0, calculator.getGoodStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetSatisfactoryStudentsCountIfExist() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(1, calculator.getSatisfactoryStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetSatisfactoryStudentsCountIfNotExist() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 5, 2, 5, 4, 4))),
                        new Student(new ArrayList<>(List.of(5, 3, 5, 2, 5, 5))),
                        new Student(new ArrayList<>(List.of(3, 2, 4, 2, 2, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 2, 5, 5, 2))),
                        new Student(new ArrayList<>(List.of(5, 3, 4, 4, 2, 4)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0, calculator.getSatisfactoryStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetBadStudentsCountIfExist() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(2, calculator.getBadStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetBadStudentsCountIfNotExist() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 3, 3, 4, 4, 5))),
                        new Student(new ArrayList<>(List.of(5, 3, 5, 4, 4, 5))),
                        new Student(new ArrayList<>(List.of(3, 4, 5, 5, 3, 5))),
                        new Student(new ArrayList<>(List.of(5, 3, 5, 5, 5, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 4, 5, 4, 4)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0, calculator.getBadStudentsCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetStudentsAverageRating() {
        List<Student> students = generateDefaultStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(4.2, calculator.getAverageRating(), COMPARE_DELTA);
    }

    @Test
    public void canGetStudentsAverageRatingIfAllStudentsAreEmpty() {
        List<Student> students = generateEmptyStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0.0, calculator.getAverageRating(), COMPARE_DELTA);
    }

    @Test
    public void canGetStudentsAverageRatingIfIsEmptyStudent() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(4, 4, 2, 5, 3, 5))),
                        new Student(),
                        new Student(new ArrayList<>(List.of(5, 2, 2, 5, 4, 3))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 5, 5))),
                        new Student(new ArrayList<>(List.of(4, 4, 4, 5, 3, 3)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(4.04, calculator.getAverageRating(), COMPARE_DELTA);
    }

    @Test
    public void canGetTotalMarksCount() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(3, 3, 4, 2, 4))),
                        new Student(),
                        new Student(new ArrayList<>(List.of(3, 2, 4, 4, 2, 4))),
                        new Student(new ArrayList<>(List.of(5, 5, 2, 5, 5, 3, 4))),
                        new Student(new ArrayList<>(List.of(3, 5, 5)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(21, calculator.getTotalMarksCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetTotalMarksCountIfNoMarks() {
        List<Student> students = generateEmptyStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0, calculator.getTotalMarksCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetPercentageOfTraining() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 3, 5, 2, 4))),
                        new Student(),
                        new Student(new ArrayList<>(List.of(5, 2, 2, 3, 4, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 4, 5, 5, 4))),
                        new Student(new ArrayList<>(List.of(5, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 5, 5, 5, 4, 2, 3, 5, 2))),
                        new Student(new ArrayList<>(List.of(3, 5, 4)))
                )
        );
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(50.0, calculator.getPercentageOfTraining(), COMPARE_DELTA);
    }

    @Test
    public void canGetPercentageOfTrainingIfNoMarks() {
        List<Student> students = generateEmptyStudentsList();
        PerformanceCalculator calculator = new PerformanceCalculator(students);
        assertEquals(0.0, calculator.getPercentageOfTraining(), COMPARE_DELTA);
    }

    private List<Student> generateDefaultStudentsList() {
        return new ArrayList<>(
                List.of(
                        new Student(new ArrayList<>(List.of(5, 3, 2, 5, 4, 4))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 5, 5, 5))),
                        new Student(new ArrayList<>(List.of(3, 2, 4, 5, 2, 5))),
                        new Student(new ArrayList<>(List.of(5, 5, 5, 5, 5, 4))),
                        new Student(new ArrayList<>(List.of(3, 5, 4, 4, 4, 3)))
                )
        );
    }

    private List<Student> generateEmptyStudentsList() {
        return new ArrayList<>(
                List.of(
                        new Student(),
                        new Student(),
                        new Student(),
                        new Student(),
                        new Student()
                )
        );
    }
}
