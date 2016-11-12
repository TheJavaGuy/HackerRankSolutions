package org.thejavaguy.hackerrank.dynamicprogramming.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TheMaximumSubarray {
    public long maxSubarray(final int[] arr) {
        long ret = 0;
        for (int element : arr) {
            if (element > 0) {
                ret += element;
            }
        }
        return ret;
    }

    public long maxContiguousSubarray(final int[] arr) {
        long maxSoFar = Integer.MIN_VALUE;
        long maxEndingHere = 0;
        for (int i = 0; i < arr.length; ++i) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        final TheMaximumSubarray app = new TheMaximumSubarray();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfCases; ++testCase) {
                final int numberOfElements = in.nextInt();
                final int[] arr = new int[numberOfElements];
                for (int element = 0; element < numberOfElements; ++element) {
                    arr[element] = in.nextInt();
                }
                long maxc = app.maxContiguousSubarray(arr);
                long maxnc = app.maxSubarray(arr);
                if (maxc > 0 || maxnc > 0) {
                    System.out.println(app.maxContiguousSubarray(arr) + " " + app.maxSubarray(arr));
                } else {
                    System.out.println(arr[0] + " " + arr[0]);
                }
            }
        }
    }
}
