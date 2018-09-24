package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SherlockAndTheBeast {
    private final static String THREES = "33333";
    private final static String FIVES = "555";

    public String decentNumber(int numberOfDigits) {
        if (numberOfDigits == 1 || numberOfDigits == 2 || numberOfDigits == 4 || numberOfDigits == 7) {
            return "-1";
        }
        int digitsLeft = numberOfDigits;
        StringBuilder ret = new StringBuilder();
        for (;;) {
            if (digitsLeft == 0) {
                break;
            }
            if (digitsLeft == 5 || digitsLeft == 10) {
                ret.append(THREES);
                digitsLeft -= THREES.length();
            } else {
                ret.append(FIVES);
                digitsLeft -= FIVES.length();
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        final SherlockAndTheBeast app = new SherlockAndTheBeast();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numberOfTestCases; ++i) {
                final int numberOfDigits = Integer.parseInt(in.nextLine());
                System.out.println(app.decentNumber(numberOfDigits));
            }
        }
    }
}
