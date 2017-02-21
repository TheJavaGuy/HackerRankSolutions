package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class ServiceLane {
    public int min(final int[] arr, final int start, final int end) {
        int ret = Integer.MAX_VALUE;
        for (int i = start; i <= end; ++i) {
            if (arr[i] < ret) {
                ret = arr[i];
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        ServiceLane app = new ServiceLane();
        try (Scanner in = new Scanner(System.in)) {
            final int lengthOfFreeway = in.nextInt();
            final int numberOfTestCases = in.nextInt();
            final int[] width = new int[lengthOfFreeway];
            for (int i = 0; i < lengthOfFreeway; ++i) {
                width[i] = in.nextInt();
            }
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int entrySegment = in.nextInt();
                final int exitSegment = in.nextInt();
                System.out.println(app.min(width, entrySegment, exitSegment));
            }
        }
    }
}
