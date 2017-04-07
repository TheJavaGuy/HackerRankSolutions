package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class BreakingTheRecord {
    private int[] recordBreaks(int[] scores) {
        int[] ret = new int[2];
        if (scores.length <= 1) {
            return ret;
        }
        int currentMost = scores[0];
        int currentLeast = scores[0];
        for (int i = 1; i < scores.length; ++i) {
            if (scores[i] > currentMost) {
                ++ret[0];
                currentMost = scores[i];
            };
            if (scores[i] < currentLeast) {
                ++ret[1];
                currentLeast = scores[i];
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        final BreakingTheRecord app = new BreakingTheRecord();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfGames = in.nextInt();
            final int[] scores = new int[numberOfGames];
            for (int i = 0; i < scores.length; ++i) {
                scores[i] = in.nextInt();
            }
            int[] ret = app.recordBreaks(scores);
            System.out.println(ret[0] + " " + ret[1]);
        }
    }
}
