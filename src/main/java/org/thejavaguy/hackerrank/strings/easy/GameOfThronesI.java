package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class GameOfThronesI {
    public String canBecomePalindrome(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        final int[] occurences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++occurences[s.charAt(i) - 'a'];
        }
        if (s.length() % 2 == 0) {
            if (odds(occurences) > 0) {
                return "NO";
            } else {
                return "YES";
            }
        } else {
            if (odds(occurences) != 1) {
                return "NO";
            } else {
                return "YES";
            }
        }
    }

    private int odds(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] % 2 != 0) {
                ++ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final GameOfThronesI app = new GameOfThronesI();
        try (Scanner in = new Scanner(System.in)) {
            final String s = in.nextLine();
            System.out.println(app.canBecomePalindrome(s));
        }
    }
}
