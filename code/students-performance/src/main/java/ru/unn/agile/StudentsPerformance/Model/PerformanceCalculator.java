package ru.unn.agile.StudentsPerformance.Model;

import java.util.List;

public class PerformanceCalculator {

    private static final int MAX_PERCENT_VALUE = 100;

    private List<Student> students;

    public PerformanceCalculator(final List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("The list of students can't be null or empty");
        }
        this.students = students;
    }

    public int getExcellentStudentsCount() {
        return (int) students.stream().filter(Student::checkIsExcellent).count();
    }

    public int getGoodStudentsCount() {
        return (int) students.stream().filter(Student::checkIsGood).count();
    }

    public int getSatisfactoryStudentsCount() {
        return (int) students.stream().filter(Student::checkIsSatisfactory).count();
    }

    public int getBadStudentsCount() {
        return (int) students.stream().filter(Student::checkIsBad).count();
    }

    public double getAverageRating() {
        double marksSum = students.stream().mapToDouble(Student::getAverageRating).sum();
        double studentsCount = students.stream().filter(this::checkIsCertified).count();

        if (studentsCount == 0) {
            return 0.0;
        }
        return marksSum / studentsCount;
    }

    public int getTotalMarksCount() {
        return students.stream().mapToInt(Student::getMarksCount).sum();
    }

    public double getPercentageOfTraining() {
        int certifiedStudents = getExcellentStudentsCount()
                + getGoodStudentsCount()
                + getSatisfactoryStudentsCount();
        double studentsCount = students.stream().filter(this::checkIsCertified).count();

        if (studentsCount == 0) {
            return 0.0;
        }
        return certifiedStudents / studentsCount * MAX_PERCENT_VALUE;
    }

    private boolean checkIsCertified(final Student student) {
        return student.getAverageRating() != 0.0;
    }
}
