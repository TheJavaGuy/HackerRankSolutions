package org.thejavaguy.hackerrank.bitmanipulation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SumVsXOR {
    public long sumXor(long n) {
        return 1L << numberOfZeroBits(n);
    }

    private int numberOfZeroBits(long n) {
        int ret = 0;
        while (n > 0) {
            if ((n & 1) ==0) {
                ++ret;
            }
            n >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        final SumVsXOR app = new SumVsXOR();
        try (Scanner in = new Scanner(System.in)) {
            final long n = Long.parseLong(in.nextLine());
            System.out.println(app.sumXor(n));
        }
    }
}
