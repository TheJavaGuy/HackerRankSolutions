package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Arrays;
import java.util.Scanner;

public final class GridChallenge {
    public String isGrid(char[][] matrix) {
        for (int row = 0; row < matrix.length - 1; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                if (matrix[row][col] > matrix[row + 1][col]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        final GridChallenge app = new GridChallenge();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = Integer.parseInt(in.nextLine());
            for (int testCase = 0; testCase < numberOfTestCases; ++testCase) {
                final int numberOfRows = Integer.parseInt(in.nextLine());
                final char[][] testCaseMatrix = new char[numberOfRows][numberOfRows];
                for (int row = 0; row < numberOfRows; ++row) {
                    final char[] line = in.nextLine().toCharArray();
                    Arrays.sort(line);
                    testCaseMatrix[row] = line;
                }
                System.out.println(app.isGrid(testCaseMatrix));
            }
        }
    }
}
