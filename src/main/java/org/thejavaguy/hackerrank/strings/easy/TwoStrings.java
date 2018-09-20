package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TwoStrings {
    public String shareCommonSubstring(String s1, String s2) {
        final int[] occurences1 = occurences(s1);
        final int[] occurences2 = occurences(s2);
        for (int i = 0; i < occurences1.length; ++i) {
            if (occurences1[i] > 0 && occurences2[i] > 0) {
                return "YES";
            }
        }
        return "NO";
    }

    private int[] occurences(String word) {
        final int[] ret = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ++ret[word.charAt(i) - 'a'];
        }
        return ret;
    }

    public static void main(String[] args) {
        final TwoStrings app = new TwoStrings();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = Integer.parseInt(in.nextLine());
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final String s1 = in.nextLine();
                final String s2 = in.nextLine();
                System.out.println(app.shareCommonSubstring(s1, s2));
            }
        }
    }
}
