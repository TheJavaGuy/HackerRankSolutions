package org.thejavaguy.hackerrank.bitmanipulation.easy;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class FlippingBits {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int listSize = in.nextInt();
            for (int i = 0; i < listSize; ++i) {
                final long unsigned = in.nextLong();
                long maxValue = (long)Math.pow(2, 32) - 1;
                System.out.println(unsigned ^ maxValue);
            }
        }
    }
}
