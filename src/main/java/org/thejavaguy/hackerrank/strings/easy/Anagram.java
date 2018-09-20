package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class Anagram {
    public int numberOfChanges(String word) {
        if (word.length() % 2 != 0) {
            return -1;
        }
        final int[] occurences1 = occurences(word.substring(0, word.length() / 2));
        final int[] occurences2 = occurences(word.substring(word.length() / 2));
        int ret = 0;
        for (int i = 0; i < occurences1.length; ++i) {
            ret += Math.max(occurences1[i] - occurences2[i], 0);
        }
        return ret;
    }

    private int[] occurences(String word) {
        final int[] ret = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ++ret[word.charAt(i) - 'a'];
        }
        return ret;
    }

    public static void main(String[] args) {
        final Anagram app = new Anagram();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = Integer.parseInt(in.nextLine());
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final String word = in.nextLine();
                System.out.println(app.numberOfChanges(word));
            }
        }
    }
}
