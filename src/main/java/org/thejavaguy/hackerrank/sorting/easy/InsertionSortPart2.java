package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class InsertionSortPart2 {
    public static void insertionSortPart2(int[] ar) {
        for (int ptrUnsorted = 1; ptrUnsorted < ar.length; ++ptrUnsorted) {
            if (ar[ptrUnsorted] >= ar[ptrUnsorted - 1]) {
                printArray(ar);
                continue;
            }
            int toSort = ar[ptrUnsorted];
            int ptrToWrite = ptrUnsorted;
            // find the place
            for (;;) {
                if (ptrToWrite == 0 || toSort >= ar[ptrToWrite - 1]) {
                    ar[ptrToWrite] = toSort;
                    break;
                }
                ar[ptrToWrite] = ar[ptrToWrite - 1];
                --ptrToWrite;
            }
            printArray(ar);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
