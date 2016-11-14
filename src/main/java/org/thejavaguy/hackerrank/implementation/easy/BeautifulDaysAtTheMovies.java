package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class BeautifulDaysAtTheMovies {
    public int reversed(final int number) {
        if (number < 10) {
            return number;
        }
        StringBuilder reversed = new StringBuilder(String.valueOf(number));
        return Integer.parseUnsignedInt(reversed.reverse().toString(), 10);
    }

    public boolean isBeautiful(final int number, final int k) {
        return Math.abs(number - reversed(number)) % k == 0;
    }

    public int numberOfBeautifulDays(final int start, final int end, final int k) {
        int ret = 0;
        for (int currentDay = start; currentDay <= end; ++currentDay) {
            if (isBeautiful(currentDay, k)) {
                ++ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        BeautifulDaysAtTheMovies app = new BeautifulDaysAtTheMovies();
        try (Scanner in = new Scanner(System.in)) {
            int startDay = in.nextInt();
            int endDay = in.nextInt();
            int k = in.nextInt();
            System.out.println(app.numberOfBeautifulDays(startDay, endDay, k));
        }
    }
}
