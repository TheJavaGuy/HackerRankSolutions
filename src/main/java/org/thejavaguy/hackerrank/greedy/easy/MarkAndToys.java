package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MarkAndToys {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final String[] numberAndAmount = in.nextLine().split(" ");
            final int numberOfToys = Integer.parseInt(numberAndAmount[0]);
            final int amount = Integer.parseInt(numberAndAmount[1]);
            final String[] pricesStr = in.nextLine().split(" ");
            final Integer[] prices = new Integer[numberOfToys];
            for (int i = 0; i < prices.length; ++i) {
                prices[i] = Integer.decode(pricesStr[i]);
            }
            Arrays.sort(prices);
            int amountLeft = amount;
            int bought = 0;
            for (int i = 0; i < prices.length; ++i) {
                if (amountLeft >= prices[i]) {
                    amountLeft -= prices[i];
                    ++bought;
                } else {
                    break;
                }
            }
            System.out.println(bought);
        }
    }
}
