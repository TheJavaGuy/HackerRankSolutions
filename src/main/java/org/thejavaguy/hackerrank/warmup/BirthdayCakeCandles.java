package org.thejavaguy.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class BirthdayCakeCandles {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numOfCandles = in.nextInt();
            final int[] candles = new int[numOfCandles];
            int maxHeight = Integer.MIN_VALUE;
            for (int i = 0; i < numOfCandles; ++i) {
                candles[i] = in.nextInt();
                if (candles[i] > maxHeight) {
                	maxHeight = candles[i];
                }
            }
            int ret = 0;
            for (int i = 0; i < numOfCandles; ++i) {
            	if (candles[i] == maxHeight) {
            		++ret;
            	}
            }
            System.out.println(ret);
        }
    }
}
