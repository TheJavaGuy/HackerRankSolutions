package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MiniMaxSum {
    public long sumWithoutIndex(int[] arr, int index) {
        long ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (i == index) {
                continue;
            }
            ret += arr[i];
        }
        return ret;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[] arr = new int[5];
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = in.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            MiniMaxSum app = new MiniMaxSum();
            System.out.print(app.sumWithoutIndex(arr, maxIndex));
            System.out.print(" ");
            System.out.print(app.sumWithoutIndex(arr, minIndex));
        }
    }
}
