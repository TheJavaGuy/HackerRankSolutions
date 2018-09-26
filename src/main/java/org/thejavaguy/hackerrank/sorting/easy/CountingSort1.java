package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

public final class CountingSort1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[size];
            final int[] counts = new int[100];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
                ++counts[arr[i]];
            }
            printArray(counts);
        }
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
