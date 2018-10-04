package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

public final class SeparateTheNumbers {
    public String isBeautiful(String query) {
        if (query.length() == 1) {
            return "NO";
        }
        if (query.startsWith("0")) {
            return "NO";
        }
        for (int startingDigits = 1; startingDigits <= query.length() / 2; ++startingDigits) {
            long start = Long.parseLong(query.substring(0, startingDigits));
            if (candidate(query, start).equals(query)) {
                return "YES " + start;
            }
        }
        return "NO";
    }

    private String candidate(String query, long start) {
        StringBuilder candidate = new StringBuilder(String.valueOf(start));
        long current = start + 1;
        for (;;) {
            if (candidate.length() >= query.length()) {
                return candidate.toString();
            }
            candidate.append(String.valueOf(current));
            ++current;
        }
    }

    public static void main(String[] args) {
        final SeparateTheNumbers app = new SeparateTheNumbers();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfQueries = Integer.parseInt(in.nextLine());
            for (int query = 0; query < numberOfQueries; ++query) {
                System.out.println(app.isBeautiful(in.nextLine()));
            }
        }
    }
}
