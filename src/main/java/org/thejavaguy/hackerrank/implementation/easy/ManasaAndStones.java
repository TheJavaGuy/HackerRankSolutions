package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class ManasaAndStones {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int numberOfStones = in.nextInt();
                final int diffA = in.nextInt();
                final int diffB = in.nextInt();
                final TreeSet<Integer> possibleFinalStones = new TreeSet<>();
                for (int numOfBs = 0; numOfBs <= numberOfStones - 1; ++numOfBs) {
                    final int numOfAs = numberOfStones - 1 - numOfBs;
                    possibleFinalStones.add(diffA * numOfAs + diffB * numOfBs);
                }
                for (Integer currentValue : possibleFinalStones) {
                    System.out.print(currentValue + " ");
                }
                System.out.println();
            }
        }
    }
}
