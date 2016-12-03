package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class ViralAdvertising {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfDays = in.nextInt();
            int output = 5;
            int totalLikes = 0;
            for (int day = 1; day <= numberOfDays; ++day) {
                int newLikes = output / 2;
                totalLikes += newLikes;
                output = newLikes * 3;
            }
            System.out.println(totalLikes);
        }
    }
}
