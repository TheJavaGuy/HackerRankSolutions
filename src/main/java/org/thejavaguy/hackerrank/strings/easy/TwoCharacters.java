package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

public final class TwoCharacters {
    public String alternate(String input) {
        if (input.length() < 2) {
            return "";
        }
        if (isValid(input)) {
            return input;
        }
        int max = Integer.MIN_VALUE;
        String ret = "";
        for (char first = 'a'; first < 'z'; ++first) {
            for (char second = 'b'; second <= 'z'; ++second) {
                String candidate = leave(input, first, second);
                if (isValid(candidate)) {
                    if (candidate.length() > max) {
                        ret = candidate;
                        max = candidate.length();
                    }
                }
            }
        }
        return ret;
    }

    private boolean isValid(String candidate) {
        if (candidate.length() < 2) {
            return false;
        }
        char first = candidate.charAt(0);
        char second = candidate.charAt(1);
        if (first == second) {
            return false;
        }
        for (int i = 2; i < candidate.length(); ++i) {
            char currentChar = candidate.charAt(i);
            if (i % 2 == 0) {
                if (currentChar != first) {
                    return false;
                }
            } else {
                if (currentChar != second) {
                    return false;
                }
            }
        }
        return true;
    }

    private String leave(String input, char first, char second) {
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            if (currentChar == first || currentChar == second) {
                ret.append(currentChar);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        final TwoCharacters app = new TwoCharacters();
        try (Scanner in = new Scanner(System.in)) {
            final int length = Integer.parseInt(in.nextLine());
            final String s = in.nextLine();
            System.out.println(app.alternate(s).length());
        }
    }
}
