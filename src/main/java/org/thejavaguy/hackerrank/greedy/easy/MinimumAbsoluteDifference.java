package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[size];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            Arrays.sort(arr);
            int minimumAbsoluteDifference = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; ++i) {
                if (Math.abs(arr[i] - arr[i + 1]) < minimumAbsoluteDifference) {
                    minimumAbsoluteDifference = Math.abs(arr[i] - arr[i + 1]);
                }
            }
            System.out.println(minimumAbsoluteDifference);
        }
    }
}
