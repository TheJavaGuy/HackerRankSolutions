package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class LibraryFine {
    private int[] dateComponents(final Scanner in, final int size) {
        int[] ret = new int[size];
        for (int i = 0; i < size; ++i) {
            ret[i] = in.nextInt();
        }
        return ret;
    }
    
    private int fineYear(final int actualYear, final int expectedYear) {
        if (actualYear > expectedYear) {
            return 10000;
        }
        return 0;
    }
    
    private int fineMonth(final int actualMonth, final int expectedMonth) {
        if (actualMonth > expectedMonth) {
            return 500 * (actualMonth - expectedMonth);
        }
        return 0;
    }
    
    private int fineDay(final int actualDay, final int expectedDay) {
        if (actualDay > expectedDay) {
            return 15 * (actualDay - expectedDay);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        final LibraryFine app = new LibraryFine();
        final int NUM_COMPONENTS = 3;
        try (Scanner in = new Scanner(System.in)) {
            final int[] actual = app.dateComponents(in, NUM_COMPONENTS);
            final int[] expected = app.dateComponents(in, NUM_COMPONENTS);
            if (actual[2] < expected[2]) {
                System.out.println(0);
                return;
            } else if (actual[2] == expected[2]) {
                if (actual[1] < expected[1]) {
                    System.out.println(0);
                    return;
                } else if (actual[1] == expected[1]) {
                    if (actual[0] < expected[0]) {
                        System.out.println(0);
                        return;
                    } else if (actual[0] == expected[0]) {
                        System.out.println(0);
                        return;
                    } else {
                        System.out.println(app.fineDay(actual[0], expected[0]));
                        return;
                    }
                } else {
                    System.out.println(app.fineMonth(actual[1], expected[1]));
                    return;
                }
            } else {
                System.out.println(app.fineYear(actual[2], expected[2]));
                return;
            }
        }
    }
}
