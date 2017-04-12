package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class DrawingBook {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfPages = in.nextInt();
            final int destinationPage = in.nextInt();
            final int normalizedStart = 0;
            final int normalizedEnd = numberOfPages / 2;
            final int normalizedDestination = destinationPage / 2;
            System.out.println(Math.min(normalizedEnd - normalizedDestination, normalizedDestination - normalizedStart));
        }
    }
}
