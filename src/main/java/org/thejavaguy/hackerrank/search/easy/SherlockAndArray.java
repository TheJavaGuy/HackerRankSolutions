package org.thejavaguy.hackerrank.search.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SherlockAndArray {
    public long sum(final int[] arr) {
        long ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            ret += arr[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        final SherlockAndArray app = new SherlockAndArray();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int numberOfElements = in.nextInt();
                final int[] arr = new int[numberOfElements];
                for (int element = 0; element < numberOfElements; ++element) {
                    arr[element] = in.nextInt();
                }
                boolean exists = false;
                final long sum = app.sum(arr);
                long partialLeftSum = 0;
                long partialRightSum = sum;
                for (int index = 0; index < arr.length; ++index) {
                    if (index > 0) {
                        partialLeftSum += arr[index - 1];
                    }
                    partialRightSum -= arr[index];
                    if (partialLeftSum == partialRightSum) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
