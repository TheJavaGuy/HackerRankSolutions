package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class TaumAndBday {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int i = 0; i < numberOfTestCases; ++i) {
                final long blackGifts = in.nextInt();
                final long whiteGifts = in.nextInt();
                final long costOfBlackGift = in.nextInt();
                final long costOfWhiteGift = in.nextInt();
                final long costOfConverting = in.nextInt();
                long realCostOfBlack = Math.min(costOfBlackGift, costOfWhiteGift + costOfConverting);
                long realCostOfWhite = Math.min(costOfWhiteGift, costOfBlackGift + costOfConverting);
                System.out.println(blackGifts * realCostOfBlack + whiteGifts * realCostOfWhite);
            }
        }
    }
}
