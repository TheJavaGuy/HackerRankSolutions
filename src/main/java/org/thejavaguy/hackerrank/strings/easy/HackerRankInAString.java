package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class HackerRankInAString {
    public String containsHackerRank(String query) {
        final String hackerRank = "hackerrank";
        int ptr = 0;
        for (int i = 0; i < query.length(); ++i) {
            if (query.charAt(i) == hackerRank.charAt(ptr)) {
                ++ptr;
                if (ptr == hackerRank.length()) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        final HackerRankInAString app = new HackerRankInAString();
        try (Scanner in = new Scanner(System.in)) {
            final int numQueries = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numQueries; ++i) {
                final String query = in.nextLine();
                System.out.println(app.containsHackerRank(query));
            }
        }
    }
}
