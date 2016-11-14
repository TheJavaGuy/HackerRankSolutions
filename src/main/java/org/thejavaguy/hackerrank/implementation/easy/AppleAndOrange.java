package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class AppleAndOrange {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            int[] apple = new int[m];
            for (int apple_i = 0; apple_i < m; apple_i++) {
                apple[apple_i] = in.nextInt();
            }
            int[] orange = new int[n];
            for (int orange_i = 0; orange_i < n; orange_i++) {
                orange[orange_i] = in.nextInt();
            }
            int appleLowerBound = s - a;
            int appleUpperBound = t - a;
            int orangeLowerBound = s - b;
            int orangeUpperBound = t - b;
            int numberOfApples = 0;
            for (int i = 0; i < apple.length; ++i) {
                if (apple[i] >= appleLowerBound && apple[i] <= appleUpperBound) {
                    ++numberOfApples;
                }
            }
            System.out.println(numberOfApples);
            int numberOfOranges = 0;
            for (int i = 0; i < orange.length; ++i) {
                if (orange[i] >= orangeLowerBound && orange[i] <= orangeUpperBound) {
                    ++numberOfOranges;
                }
            }
            System.out.println(numberOfOranges);
        }
    }
}
