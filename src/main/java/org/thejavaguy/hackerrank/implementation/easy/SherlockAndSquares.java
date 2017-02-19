package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SherlockAndSquares {
    private static final int MAX_NUMBER = 31633;
    private final Map<Integer, Integer> squares;

    public SherlockAndSquares() {
        this.squares = new TreeMap<>();
        for (int i = 0; i <= MAX_NUMBER; ++i) {
            squares.put(i * i, i);
        }
    }

    private long keysInRange(final int start, final int end) {
        return squares.keySet().stream().filter(k -> k >= start && k <= end).count();
    }

    public static void main(String[] args) {
        SherlockAndSquares app = new SherlockAndSquares();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int start = in.nextInt();
                final int end = in.nextInt();
                System.out.println(app.keysInRange(start, end));
            }
        }
    }
}
