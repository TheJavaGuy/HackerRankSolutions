package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TheBirthdayBar {
    private int sumOfNConsecutive(int[] arr, int start, int n) {
        int ret = 0;
        int end = start + n - 1;
        if (end >= arr.length) {
            return ret;
        }
        for (int i = start; i <= end; ++i) {
            ret += arr[i];
        }
        return ret;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSquares = in.nextInt();
            final int[] squares = new int[numberOfSquares];
            for (int i = 0; i < numberOfSquares; ++i) {
                squares[i] = in.nextInt();
            }
            final int birthDay = in.nextInt();
            final int birthMonth = in.nextInt();//m consecutive squares with sum == d
            if (numberOfSquares < birthMonth) {
                System.out.println(0);
                return;
            }
            int ret = 0;
            final TheBirthdayBar app = new TheBirthdayBar();
            for (int start = 0; start <= numberOfSquares - birthMonth; ++start) {
                if (birthDay == app.sumOfNConsecutive(squares, start, birthMonth)) {
                    ++ret;
                }
            }
            System.out.println(ret);
        }
    }
}
