package org.thejavaguy.hackerrank.bitmanipulation.easy;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class MaximizingXOR {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int l = in.nextInt();
            final int r = in.nextInt();
            if (l == r) {
                System.out.println(0);
                return;
            }
            int max = Integer.MIN_VALUE;
            for (int i = l; i < r; ++i) {
                for (int j = i + 1; j <= r; ++j) {
                    final int xor = i ^ j;
                    if (xor > max) {
                        max = xor;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
