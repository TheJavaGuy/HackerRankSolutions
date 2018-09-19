package org.thejavaguy.hackerrank.strings.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class FunnyStrings {
    public String funnyOrNot(String query) {
        final String reverse = new StringBuilder(query).reverse().toString();
        final char[] adjacentDiffQuery = adjacentDiff(query.toCharArray());
        final char[] adjacentDiffReverse = adjacentDiff(reverse.toCharArray());
        if (Arrays.equals(adjacentDiffQuery, adjacentDiffReverse)) {
            return "Funny";
        } else {
            return "Not Funny";
        }
    }

    private char[] adjacentDiff(char[] arr) {
        char[] ret = new char[arr.length - 1];
        for (int i = 0; i < arr.length - 1; ++i) {
            ret[i] = (char)Math.abs(arr[i] - arr[i+1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        final FunnyStrings app = new FunnyStrings();
        try (Scanner in = new Scanner(System.in)) {
            final int numQueries = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numQueries; ++i) {
                final String query = in.nextLine();
                System.out.println(app.funnyOrNot(query));
            }
        }
    }
}
