package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class Kangaroo {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private boolean alwaysAhead(final int x1, final int v1, final int x2, final int v2) {
        return (x1 >= x2 && v1 > v2) || (x2 >= x1 && v2 > v1) || (x1 > x2 && v1 >= v2) || (x2 > x1 && v2 >= v1);
    }

    public static void main(String[] args) {
        Kangaroo app = new Kangaroo();
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            final int x1 = in.nextInt();
            final int v1 = in.nextInt();
            final int x2 = in.nextInt();
            final int v2 = in.nextInt();
            if (app.alwaysAhead(x1, v1, x2, v2)) {
                System.out.println(NO);
            } else if (v1 == v2) {
                if (x1 == x2) {
                    System.out.println(YES);
                } else {
                    System.out.println(NO);
                }
            } else if (x1 == x2) {
                if (v1 == v2) {
                    System.out.println(YES);
                } else {
                    System.out.println(NO);
                }
            } else {
                final double stepsUntilMet = ((double)(x2 - x1) / (v1 - v2));
                if (stepsUntilMet <= 0) {
                    System.out.println(NO);
                } else {
                    if (Math.ceil(stepsUntilMet) == Math.floor(stepsUntilMet)) {
                        System.out.println(YES);
                    } else {
                        System.out.println(NO);
                    }
                }
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
