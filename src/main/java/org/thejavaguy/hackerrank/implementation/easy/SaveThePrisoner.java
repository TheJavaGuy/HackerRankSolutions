package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class SaveThePrisoner {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int currentTestCase = 0; currentTestCase < numberOfTestCases; ++currentTestCase) {
                final int numberOfPrisoners = in.nextInt();
                final int numberOfSweets = in.nextInt();
                final int startAt = in.nextInt();
                if (((numberOfSweets + startAt - 1) % numberOfPrisoners) == 0) {
                    System.out.println(numberOfPrisoners);
                } else {
                    System.out.println((numberOfSweets + startAt - 1) % numberOfPrisoners);
                }
            }
        }
    }
}
