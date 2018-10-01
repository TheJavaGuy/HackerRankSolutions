package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MaximumPerimeterTriangle {
    public String maximumPerimeterTriangle(int[] sticks) {
        for (int i = sticks.length - 1; i >= 2; --i) {
            for (int j = i - 1; j >= 1; --j) {
                for (int k = j - 1; k >= 0; --k) {
                    Triangle t  = new Triangle(sticks[i], sticks[j], sticks[k]);
                    if (t.isTriangle()) {
                        return t.toString();
                    }
                }
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        final MaximumPerimeterTriangle app = new MaximumPerimeterTriangle();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSticks = Integer.parseInt(in.nextLine());
            final String[] sticksStr = in.nextLine().split(" ");
            final int[] sticks = new int[numberOfSticks];
            for (int i = 0; i < sticks.length; ++i) {
                sticks[i] = Integer.parseInt(sticksStr[i]);
            }
            Arrays.sort(sticks);
            System.out.println(app.maximumPerimeterTriangle(sticks));
        }
    }

    private static class Triangle {
        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isTriangle() {
            return a + b > c && a + c > b && b + c > a;
        }

        public int maximumSide() {
            return Math.max(Math.max(a, b), c);
        }

        public int minimumSide() {
            return Math.min(Math.min(a, b), c);
        }

        public int middleSide() {
            if (a == maximumSide()) {
                return Math.max(b, c);
            } else if (b == maximumSide()) {
                return Math.max(a, c);
            } else {
                return Math.max(b, c);
            }
        }

        @Override
        public String toString() {
            return minimumSide() + " " + middleSide() + " " + maximumSide();
        }
    }
}
