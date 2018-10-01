package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TheHurdleRace {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfHurdles = in.nextInt();
            final int maximumHeight = in.nextInt();
            int maxHurdle = 0;
            for (int i = 0; i < numberOfHurdles; ++i) {
                int currentHurdle = in.nextInt();
                if (currentHurdle > maxHurdle) {
                    maxHurdle = currentHurdle;
                }
            }
            if (maxHurdle <= maximumHeight) {
                System.out.println(0);
            } else {
                System.out.println(maxHurdle - maximumHeight);
            }
        }
    }
}
