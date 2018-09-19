package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TheLoveLetterMystery {
    private boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public int reductions(String word) {
        if (isPalindrome(word)) {
            return 0;
        }
        int ptrLeft = 0;
        int ptrRight = word.length() - 1;
        int ret = 0;
        for (;;) {
            ret += Math.abs(word.charAt(ptrLeft) - word.charAt(ptrRight));
            ++ptrLeft;
            --ptrRight;
            if (ptrLeft >= ptrRight) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final TheLoveLetterMystery app = new TheLoveLetterMystery();
        try (Scanner in = new Scanner(System.in)) {
            final int numQueries = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numQueries; ++i) {
                final String query = in.nextLine();
                System.out.println(app.reductions(query));
            }
        }
    }
}
