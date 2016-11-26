package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class InsertionSortPart1 {
    public static void insertIntoSorted(int[] ar) {
        int toSort = ar[ar.length - 1];
        boolean finished = false;
        for (int i = ar.length - 2; i >= 0; --i) {
            if (ar[i] > toSort) {
                ar[i + 1] = ar[i];
            } else {
                ar[i + 1] = toSort;
                finished = true;
            }
            printArray(ar);
            if (i == 0 && !finished) {
                ar[0] = toSort;
                finished = true;
                printArray(ar);
            }
            if (finished) {
                return;
            }
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
