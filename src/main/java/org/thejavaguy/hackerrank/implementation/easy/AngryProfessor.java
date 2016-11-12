package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class AngryProfessor {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int numberOfStudents = in.nextInt();
                final int threshold = in.nextInt();
                int onTime = 0;
                for (int student = 1; student <= numberOfStudents; ++student) {
                    final int arrivalTime = in.nextInt();
                    if (arrivalTime <= 0) {
                        ++onTime;
                    }
                }
                if (onTime >= threshold) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
