package org.thejavaguy.hackerrank.strings.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class WeightedUniformStrings {
    public int[] consecutiveOccurences(String s) {
        int[] ret = new int[26];
        char previousChar = 0;
        int occurences = 0;
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            if (currentChar != previousChar) {
                occurences = 1;
            } else {
                ++occurences;
            }
            if (occurences > ret[currentChar - 'a']) {
                ret[currentChar - 'a'] = occurences;
            }
            previousChar = currentChar;
        }
        return ret;
    }

    public Set<Integer> weights(int[] consecutiveOccurences) {
        Set<Integer> ret = new HashSet<>();
        for (int i = 0; i < consecutiveOccurences.length; ++i) {
            if (consecutiveOccurences[i] == 0) {
                continue;
            }
            for (int j = 1; j <= consecutiveOccurences[i]; ++j) {
                ret.add(j * (i + 1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final WeightedUniformStrings app = new WeightedUniformStrings();
        try (Scanner in = new Scanner(System.in)) {
            final String s = in.nextLine();
            final Set<Integer> weights = app.weights(app.consecutiveOccurences(s));
            final int numberOfQueries = Integer.parseInt(in.nextLine());
            final StringBuilder output = new StringBuilder();
            for (int i = 0; i < numberOfQueries; ++i) {
                final int weight = Integer.parseInt(in.nextLine());
                if (weights.contains(Integer.valueOf(weight))) {
                    output.append("Yes").append(System.lineSeparator());
                } else {
                    output.append("No").append(System.lineSeparator());
                }
            }
            System.out.println(output.toString());
        }
    }
}
