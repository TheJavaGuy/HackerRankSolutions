package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class GradingStudents {
    private int roundedGrade(int originalGrade) {
        if (originalGrade < 38) {
            return originalGrade;
        }
        int nextMultiple = nextMultipleOfFive(originalGrade);
        if (nextMultiple - originalGrade >= 3) {
            return originalGrade;
        }
        return nextMultiple;
    }
    
    private int nextMultipleOfFive(int originalGrade) {
        if (originalGrade > 0 && originalGrade % 5 == 0) {
            return originalGrade;
        }
        return 5 * (originalGrade / 5 + 1);
    }
    
    public static void main(String[] args) {
        final GradingStudents app = new GradingStudents();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfStudents = in.nextInt();
            for (int i = 0; i < numberOfStudents; ++i) {
                final int originalGrade = in.nextInt();
                System.out.println(app.roundedGrade(originalGrade));
            }
        }
    }
}
