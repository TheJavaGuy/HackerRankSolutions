package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class PalindromeIndex {
    private int palindromeIndex(String query) {
        final char[] queryArr = query.toCharArray();
        //        if (isPalindrome(queryArr)) {
        //            return -1;
        //        }
        //as long as there are symmetrical chars, we don't need to test removal of them
        int diffStart = diffStart(queryArr);
        if (diffStart == -1) {
            return -1;
        }
        final char[] testArray = query.substring(diffStart, query.length() - diffStart).toCharArray();
        for (int i = 0; i < testArray.length; ++i) {
            if (isPalindrome(withoutCharacter(testArray, i))) {
                return diffStart + i;
            }
        }



        //        for (int i = 0; i < queryArr.length; ++i) {
        //            if (isPalindrome(withoutCharacter(queryArr, i))) {
        //                return i;
        //            }
        //        }
        return -1;
    }

    private int diffStart(char[] query) {
        int ptrLeft = 0;
        int ptrRight = query.length - 1;
        for (;;) {
            if (query[ptrLeft] != query[ptrRight]) {
                return ptrLeft;
            }
            ++ptrLeft;
            --ptrRight;
            if (ptrLeft > ptrRight) {
                break;
            }
        }
        return -1;
    }

    private boolean isPalindrome(char[] query) {
        int ptrLeft = 0;
        int ptrRight = query.length - 1;
        for (;;) {
            if (query[ptrLeft] != query[ptrRight]) {
                return false;
            }
            ++ptrLeft;
            --ptrRight;
            if (ptrLeft > ptrRight) {
                break;
            }
        }
        return true;
    }

    private char[] withoutCharacter(char[] query, int index) {
        char[] ret = new char[query.length - 1];
        int ptrInsert = 0;
        for (int i = 0; i < query.length; ++i) {
            if (i == index) {
                continue;
            }
            ret[ptrInsert] = query[i];
            ++ptrInsert;
        }
        return ret;
    }

    public static void main(String[] args) {
        final PalindromeIndex app = new PalindromeIndex();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfQueries = Integer.parseInt(in.nextLine());
            for (int testCase = 0; testCase < numberOfQueries; ++testCase) {
                final String query = in.nextLine();
                System.out.println(app.palindromeIndex(query));
            }
        }
    }
}
