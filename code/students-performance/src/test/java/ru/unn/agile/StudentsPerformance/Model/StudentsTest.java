package ru.unn.agile.StudentsPerformance.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentsTest {

    private static final double COMPARE_DELTA = 0.001;

    @Test
    public void canCreateStudentWithoutParameters() {
        Student student = new Student();
        assertNotNull(student);
    }

    @Test
    public void canCreateStudentWithMarks() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertNotNull(student);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canCheckIsMarksListNull() {
        ArrayList<Integer> marks = null;
        new Student(marks);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canCheckMarksValuesCorrectness() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(-1, 3, 0, 2, 7));
        new Student(marks);
    }

    @Test
    public void canGetMarksCount() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertEquals(5, student.getMarksCount(), COMPARE_DELTA);
    }

    @Test
    public void canGetMarksCountIfNoMarks() {
        Student student = new Student();
        assertEquals(0, student.getMarksCount(), COMPARE_DELTA);
    }

    @Test
    public void canCheckIsExcellentStudentIfIsWorse() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsExcellent());
    }

    @Test
    public void canCheckIsExcellentStudentIfIsExcellent() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 5, 5, 5, 5));
        Student student = new Student(marks);
        assertTrue(student.checkIsExcellent());
    }

    @Test
    public void canCheckIsExcellentStudentIfIsEmpty() {
        Student student = new Student();
        assertFalse(student.checkIsExcellent());
    }

    @Test
    public void canCheckIsGoodStudentIfIsWorse() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsGood());
    }

    @Test
    public void canCheckIsGoodStudentIfIsGood() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(4, 4, 5, 4, 5));
        Student student = new Student(marks);
        assertTrue(student.checkIsGood());
    }

    @Test
    public void canCheckIsGoodStudentIfIsBetter() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 5, 5, 5, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsGood());
    }

    @Test
    public void canCheckIsGoodStudentIfIsEmpty() {
        Student student = new Student();
        assertFalse(student.checkIsGood());
    }

    @Test
    public void canCheckIsSatisfactoryStudentIfIsWorse() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsSatisfactory());
    }

    @Test
    public void canCheckIsSatisfactoryStudentIfIsSatisfactory() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 3, 5));
        Student student = new Student(marks);
        assertTrue(student.checkIsSatisfactory());
    }

    @Test
    public void canCheckIsSatisfactoryStudentIfIsBetter() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 4, 4, 5, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsSatisfactory());
    }

    @Test
    public void canCheckIsSatisfactoryStudentIfIsEmpty() {
        Student student = new Student();
        assertFalse(student.checkIsSatisfactory());
    }

    @Test
    public void canCheckIsBadStudentIfIsBad() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertTrue(student.checkIsBad());
    }

    @Test
    public void canCheckIsBadStudentIfIsBetter() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 3, 5));
        Student student = new Student(marks);
        assertFalse(student.checkIsBad());
    }

    @Test
    public void canCheckIsBadStudentIfIsEmpty() {
        Student student = new Student();
        assertFalse(student.checkIsBad());
    }

    @Test
    public void canGetStudentAverageRating() {
        ArrayList<Integer> marks = new ArrayList<>(List.of(5, 3, 4, 2, 5));
        Student student = new Student(marks);
        assertEquals(3.8, student.getAverageRating(), COMPARE_DELTA);
    }

    @Test
    public void canGetStudentAverageRatingIfNoMarks() {
        Student student = new Student();
        assertEquals(0.0, student.getAverageRating(), COMPARE_DELTA);
    }
}
