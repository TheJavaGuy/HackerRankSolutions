package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class ChocolateFeast {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTrips = in.nextInt();
            for (int i = 0; i < numberOfTrips; ++i) {
                final int dollars = in.nextInt();
                final int cost = in.nextInt();
                final int wrappersForChocolate = in.nextInt();
                int chocolatesEaten = 0;
                if (dollars < cost) {
                    System.out.println(chocolatesEaten);
                    continue;
                }
                chocolatesEaten += (dollars / cost);
                int currentWrappers = chocolatesEaten;
                while (currentWrappers >= wrappersForChocolate) {
                    currentWrappers -= wrappersForChocolate;
                    ++currentWrappers;
                    ++chocolatesEaten;
                }
                System.out.println(chocolatesEaten);
            }
        }
    }
}
