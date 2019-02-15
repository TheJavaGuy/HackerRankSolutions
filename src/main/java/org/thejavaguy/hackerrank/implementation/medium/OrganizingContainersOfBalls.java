package org.thejavaguy.hackerrank.implementation.medium;

import java.util.Arrays;
import java.util.Scanner;

public final class OrganizingContainersOfBalls {
    private int[] ballsOfEachType(int[][] balls) {
        int[] ret = new int[balls.length];
        for (int i = 0; i < balls.length; ++i) {
            for (int j = 0; j < balls.length; ++j) {
                ret[i] += balls[i][j];
            }
        }
        return ret;
    }

    private int[] ballsInEachContainer(int[][] balls) {
        int[] ret = new int[balls.length];
        for (int i = 0; i < balls.length; ++i) {
            for (int j = 0; j < balls.length; ++j) {
                ret[i] += balls[j][i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final OrganizingContainersOfBalls app = new OrganizingContainersOfBalls();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfQueries = Integer.parseInt(in.nextLine());
            for (int query = 0; query < numberOfQueries; ++query) {
                final int numberOfRows = Integer.parseInt(in.nextLine());
                final int[][] balls = new int[numberOfRows][numberOfRows];
                for (int row = 0; row < balls.length; ++row) {
                    final String[] rowStr = in.nextLine().split(" ");
                    for (int col = 0; col < rowStr.length; ++col) {
                        balls[row][col] = Integer.parseInt(rowStr[col]);
                    }
                }
                final int[] ballsInEachContainer = app.ballsInEachContainer(balls);
                final int[] ballsOfEachType = app.ballsOfEachType(balls);
                Arrays.sort(ballsInEachContainer);
                Arrays.sort(ballsOfEachType);
                boolean possible = true;
                for (int j = 0; j < ballsInEachContainer.length; ++j) {
                    if (ballsInEachContainer[j] != ballsOfEachType[j]) {
                        possible = false;
                        break;
                    }
                }
                System.out.println(possible ? "Possible" : "Impossible");
            }
        }
    }
}
