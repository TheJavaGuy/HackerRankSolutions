package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class RunningTimeOfAlgorithms {
    public static int shiftsToSort(int[] ar) {
        int numberOfShifts = 0;
        for (int ptrUnsorted = 1; ptrUnsorted < ar.length; ++ptrUnsorted) {
            if (ar[ptrUnsorted] >= ar[ptrUnsorted - 1]) {
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
                ++numberOfShifts;
            }
        }
        return numberOfShifts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        int shifts = shiftsToSort(ar);
        System.out.println(shifts);
    }
}
