package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class BeautifulTriplets {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int sequenceLength = in.nextInt();
            final int beautifulDiff = in.nextInt();
            final int[] numbers = new int[sequenceLength];
            for (int i = 0; i < sequenceLength; ++i) {
                numbers[i] = in.nextInt();
            }
            int beautifulTriplets = 0;
            for (int i = 0; i < sequenceLength - 2; ++i) {
                for (int j = i + 1; j < sequenceLength - 1; ++j) {
                    if (numbers[j] - numbers[i] != beautifulDiff) {
                        continue;
                    }
                    for (int k = j + 1; k < sequenceLength; ++k) {
                        if (numbers[k] - numbers[j] != beautifulDiff) {
                            continue;
                        }
                        ++beautifulTriplets;
                    }
                }
            }
            System.out.println(beautifulTriplets);
        }
    }
}
