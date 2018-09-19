package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class MakingAnagrams {
    public int numberOfDeletionsForAnagram(String s1, String s2) {
        final int[] occurences1 = occurences(s1);
        final int[] occurences2 = occurences(s2);
        int ret = 0;
        for (int i = 0; i < occurences2.length; i++) {
            ret += Math.abs(occurences1[i] - occurences2[i]);
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
        final MakingAnagrams app = new MakingAnagrams();
        try (Scanner in = new Scanner(System.in)) {
            final String s1 = in.nextLine();
            final String s2 = in.nextLine();
            System.out.println(app.numberOfDeletionsForAnagram(s1, s2));
        }
    }
}
