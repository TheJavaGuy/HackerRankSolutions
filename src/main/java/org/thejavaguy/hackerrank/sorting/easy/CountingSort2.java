package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

public final class CountingSort2 {
    public int[] countingSort(int[] arr, int[] counts) {
        int[] ret = new int[arr.length];
        int writePtr = 0;
        for (int i = 0; i < counts.length; ++i) {
            int repeat = counts[i];
            while (repeat > 0) {
                ret[writePtr] = i;
                ++writePtr;
                --repeat;
            }
        }
        return ret;
    }

    private String asString(int[] arr) {
        StringBuilder ret = new StringBuilder(arr.length);
        for (int i = 0; i < arr.length - 1; ++i) {
            ret.append(arr[i]);
            ret.append(' ');
        }
        ret.append(arr[arr.length - 1]);
        return ret.toString();
    }

    public static void main(String[] args) {
        final CountingSort2 app = new CountingSort2();
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[size];
            final int[] counts = new int[100];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
                ++counts[arr[i]];
            }
            System.out.println(app.asString(app.countingSort(arr, counts)));
        }
    }
}
