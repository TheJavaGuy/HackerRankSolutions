package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class SequenceEquation {
    private int indexOf(int value, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfElements = in.nextInt();
            final int[] values = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; ++i) {
                values[i] = in.nextInt();
            }
            final SequenceEquation app = new SequenceEquation();
            for (int x = 1; x <= numberOfElements; ++x) {
                int firstIndex = 1 + app.indexOf(x, values);
                System.out.println(1 + app.indexOf(firstIndex, values));
            }
        }
    }
}
