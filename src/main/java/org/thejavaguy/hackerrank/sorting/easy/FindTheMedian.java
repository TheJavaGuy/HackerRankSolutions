package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Arrays;
import java.util.Scanner;

public final class FindTheMedian {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[size];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            Arrays.sort(arr);
            System.out.println(arr[arr.length / 2]);
        }
    }
}
