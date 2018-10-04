package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Scanner;

public final class LargestPermutation {
    private void largestPermutation(int[] arr, int maximumSwaps) {
        int swapsDone = 0;
        int writePtr = 0;
        int max = arr.length;
        for (;;) {
            if (swapsDone == maximumSwaps) {
                break;
            }
            if (writePtr == arr.length) {
                break;
            }
            int indexOfMax = indexOf(arr, max, writePtr);
            if (indexOfMax == writePtr) {
                --max;
                ++writePtr;
            } else {
                swap(arr, indexOfMax, writePtr);
                ++swapsDone;
                --max;
                ++writePtr;
            }
        }
    }

    private int indexOf(int[] arr, int element, int startAt) {
        for (int i = startAt; i < arr.length; ++i) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
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
        final LargestPermutation app = new LargestPermutation();
        try (Scanner in = new Scanner(System.in)) {
            final String[] lengthAndSwaps = in.nextLine().split(" ");
            final int length = Integer.parseInt(lengthAndSwaps[0]);
            final int maximumSwaps = Integer.parseInt(lengthAndSwaps[1]);
            final String[] arrStr = in.nextLine().split(" ");
            final int[] arr = new int[length];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            app.largestPermutation(arr, maximumSwaps);
            System.out.println(app.asString(arr));
        }
    }
}
