package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class Quicksort1 {
    public int[] quicksort1(int[] arr) {
        int pivot = arr[0];
        int leftSize = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < pivot) {
                ++leftSize;
            }
        }
        int[] left = new int[leftSize];
        int[] right = new int[arr.length - left.length - 1];
        int leftPtr = 0;
        int rightPtr = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < pivot) {
                left[leftPtr] = arr[i];
                ++leftPtr;
            } else {
                right[rightPtr] = arr[i];
                ++rightPtr;
            }
        }
        int[] ret = new int[arr.length];
        int retPtr = 0;
        for (int i = 0; i < left.length; ++i) {
            ret[retPtr] = left[i];
            ++retPtr;
        }
        ret[retPtr] = pivot;
        ++retPtr;
        for (int i = 0; i < right.length; ++i) {
            ret[retPtr] = right[i];
            ++retPtr;
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
        final Quicksort1 app = new Quicksort1();
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[size];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(app.asString(app.quicksort1(arr)));
        }
    }
}
