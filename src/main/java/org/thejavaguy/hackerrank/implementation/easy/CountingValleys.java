package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class CountingValleys {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSteps = in.nextInt();
            final String steps = in.next();
            boolean currentlyInValley = false;
            int currentElevation = 0;
            int numberOfValleys = 0;
            for (int i = 0; i < numberOfSteps; ++i) {
                if (steps.charAt(i) == 'U') {
                    ++currentElevation;
                    if (currentElevation >= 0) {
                        currentlyInValley = false;
                    }
                } else {
                    --currentElevation;
                    if (currentElevation < 0) {
                        if (!currentlyInValley) {
                            ++numberOfValleys;
                        }
                        currentlyInValley = true;
                    }
                }
            }
            System.out.println(numberOfValleys);
        }
    }
}
