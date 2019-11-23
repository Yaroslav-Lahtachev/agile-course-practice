package ru.unn.agile.StudentsPerformance.Model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private static final int EXCELLENT_MARK = 5;
    private static final int GOOD_MARK = 4;
    private static final int SATISFACTORY_MARK = 3;
    private static final int BAD_MARK = 2;

    private List<Integer> listOfMarks;

    public Student() {
        listOfMarks = new ArrayList<>();
    }

    public Student(final List<Integer> listOfMarks) {
        if (listOfMarks == null) {
            throw new IllegalArgumentException("The list of student marks can't be null");
        }
        if (listOfMarks.stream().anyMatch(mark -> mark < BAD_MARK || mark > EXCELLENT_MARK)) {
            throw new IllegalArgumentException("Marks must be in the range of 2 to 5");
        }
        this.listOfMarks = listOfMarks;
    }

    public int getMarksCount() {
        return listOfMarks.size();
    }

    public boolean checkIsExcellent() {
        return !listOfMarks.isEmpty()
                && listOfMarks.stream().allMatch(mark -> mark.equals(EXCELLENT_MARK));
    }

    public boolean checkIsGood() {
        return !listOfMarks.isEmpty()
                && listOfMarks.stream().allMatch(mark -> mark >= GOOD_MARK)
                && listOfMarks.stream().anyMatch(mark -> mark.equals(GOOD_MARK));
    }

    public boolean checkIsSatisfactory() {
        return !listOfMarks.isEmpty()
                && listOfMarks.stream().allMatch(mark -> mark >= SATISFACTORY_MARK)
                && listOfMarks.stream().anyMatch(mark -> mark.equals(SATISFACTORY_MARK));
    }

    public boolean checkIsBad() {
        return !listOfMarks.isEmpty()
                && listOfMarks.stream().anyMatch(mark -> mark.equals(BAD_MARK));
    }

    public Double getAverageRating() {
        if (listOfMarks.isEmpty()) {
            return 0.0;
        }

        double marksCount = listOfMarks.size();
        double marksSum = listOfMarks.stream().mapToInt(Integer::intValue).sum();
        return marksSum / marksCount;
    }
}
