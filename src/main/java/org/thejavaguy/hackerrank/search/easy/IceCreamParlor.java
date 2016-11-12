package org.thejavaguy.hackerrank.search.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class IceCreamParlor {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfVisits = in.nextInt();
            visits: for (int visit = 0; visit < numberOfVisits; ++visit) {
                final int bucks = in.nextInt();
                final int numberOfFlavors = in.nextInt();
                final int[] prices = new int[numberOfFlavors];
                for (int flavor = 0; flavor < numberOfFlavors; ++flavor) {
                    prices[flavor] = in.nextInt();
                }
                for (int sunnyIndex = 0; sunnyIndex < numberOfFlavors - 1; ++sunnyIndex) {
                    for (int johnnyIndex = sunnyIndex + 1; johnnyIndex < numberOfFlavors; ++johnnyIndex) {
                        if (prices[sunnyIndex] + prices[johnnyIndex] == bucks) {
                            System.out.println((sunnyIndex+1) + " " + (johnnyIndex+1));
                            continue visits;
                        }
                    }
                }
            }
        }
    }
}
