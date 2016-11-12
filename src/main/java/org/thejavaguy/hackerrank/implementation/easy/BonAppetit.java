package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class BonAppetit {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numOfItemsOrdered = in.nextInt();
            final int itemAnnaSkipped = in.nextInt();
            int totalSum = 0;
            int totalSumWithoutSkippedItem = 0;
            for (int i = 0; i < numOfItemsOrdered; ++i) {
                final int ithCost = in.nextInt();
                totalSum += ithCost;
                if (i != itemAnnaSkipped) {
                    totalSumWithoutSkippedItem += ithCost;
                }
            }
            final int bcharged = in.nextInt();
            if (totalSum / 2 == bcharged) {
                final int fairCharge = totalSumWithoutSkippedItem / 2;
                System.out.println(bcharged - fairCharge);
            } else {
                System.out.println("Bon Appetit");
            }
        }
    }
}
