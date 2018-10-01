package org.thejavaguy.hackerrank.sorting.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class ClosestNumbers {
    private final List<Pair> pairs;

    public ClosestNumbers() {
        this.pairs = new ArrayList<>();
    }

    private void add(Pair pair) {
        if (pairs.isEmpty()) {
            pairs.add(pair);
        } else {
            if (pairs.get(0).absoluteDifference() < pair.absoluteDifference()) {
                return;
            } else if (pairs.get(0).absoluteDifference() == pair.absoluteDifference()) {
                pairs.add(pair);
            } else {
                pairs.clear();
                pairs.add(pair);
            }
        }
    }

    private String pairs() {
        return pairs
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        final ClosestNumbers app = new ClosestNumbers();
        try (Scanner in = new Scanner(System.in)) {
            final int length = Integer.parseInt(in.nextLine());
            final String[] numbersStr = in.nextLine().split(" ");
            final int[] numbers = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; ++i) {
                numbers[i] = Integer.parseInt(numbersStr[i]);
            }
            Arrays.sort(numbers);
            for (int i = 0; i < numbers.length - 1; ++i) {
                app.add(new Pair(numbers[i], numbers[i + 1]));
            }
            System.out.println(app.pairs());
        }
    }

    private static final class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int absoluteDifference() {
            return Math.abs(first - second);
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }
}
