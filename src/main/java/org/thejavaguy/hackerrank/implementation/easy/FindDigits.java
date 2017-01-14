package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class FindDigits {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int number = in.nextInt();
                int ret = 0;
                final char[] digits = Integer.toString(number).toCharArray();
                for (int i = 0; i < digits.length; ++i) {
                    if (digits[i] == '0') {
                        continue;
                    }
                    int digit = Character.getNumericValue(digits[i]);
                    if (number % digit == 0) {
                        ++ret;
                    }
                }
                System.out.println(ret);
            }
        }
    }
}
