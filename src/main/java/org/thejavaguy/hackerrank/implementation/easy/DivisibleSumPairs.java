package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class DivisibleSumPairs {
    public boolean divisible(final int first, final int second, final int k) {
        return (first + second) % k == 0;
    }

    public static void main(String[] args) {
        DivisibleSumPairs app = new DivisibleSumPairs();
        try (Scanner in = new Scanner(System.in)) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            final int[] arr = new int[n];
            for (int writePtr = 0; writePtr < n; ++writePtr) {
                arr[writePtr] = in.nextInt();
            }
            int numberOfDivisiblePairs = 0;
            for (int firstPtr = 0; firstPtr < arr.length - 1; ++firstPtr) {
                for (int secondPtr = firstPtr + 1; secondPtr < arr.length; ++secondPtr) {
                    if (app.divisible(arr[firstPtr], arr[secondPtr], k)) {
                        ++numberOfDivisiblePairs;
                    }
                }
            }
            System.out.println(numberOfDivisiblePairs);
        }
    }
}
