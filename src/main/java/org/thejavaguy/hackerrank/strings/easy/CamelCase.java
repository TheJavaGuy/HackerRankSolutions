package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class CamelCase {
    public boolean startsWithLowercase(final String s) {
        return s.toLowerCase().charAt(0) == s.charAt(0);
    }

    public int uppercaseLetters(final String s) {
        final char[] origin = s.toCharArray();
        final char[] upper = s.toUpperCase().toCharArray();
        int ret = 0;
        for (int i = 0; i < origin.length; ++i) {
            if (origin[i] == upper[i]) {
                ++ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final CamelCase app = new CamelCase();
        try (Scanner in = new Scanner(System.in)) {
            final String s = in.nextLine();
            if (!app.startsWithLowercase(s)) {
                System.out.println(0);
                return;
            }
            System.out.println(app.uppercaseLetters(s) + 1);
        }
    }
}
