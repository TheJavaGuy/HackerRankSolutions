package org.thejavaguy.hackerrank.implementation.medium;

import java.util.Scanner;

public final class ThreeDSurfaceArea {
    public int surfaceArea(int[][] toy) {
        return maxArea(toy) - deductionsFromNeighbourTowers(toy) - deductionsFromSelfTower(toy);
    }

    private int maxArea(int[][] toy) {
        int ret = 0;
        for (int row = 0; row < toy.length; ++row) {
            for (int col = 0; col < toy[row].length; ++col) {
                ret += toy[row][col];
            }
        }
        return 6 * ret;
    }

    private int deductionsFromNeighbourTowers(int[][] toy) {
        int ret = 0;
        for (int row = 0; row < toy.length; ++row) {
            for (int col = 0; col < toy[row].length; ++col) {
                int rowNorth = row - 1;
                int colNorth = col;
                if (rowNorth >= 0 && rowNorth < toy.length) {
                    ret += Math.min(toy[row][col], toy[rowNorth][colNorth]);
                }
                int rowEast = row;
                int colEast = col + 1;
                if (colEast >= 0 && colEast < toy[row].length) {
                    ret += Math.min(toy[row][col], toy[rowEast][colEast]);
                }
                int rowSouth = row + 1;
                int colSouth = col;
                if (rowSouth >= 0 && rowSouth < toy.length) {
                    ret += Math.min(toy[row][col], toy[rowSouth][colSouth]);
                }
                int rowWest = row;
                int colWest = col - 1;
                if (colWest >= 0 && colWest < toy[row].length) {
                    ret += Math.min(toy[row][col], toy[rowWest][colWest]);
                }
            }
        }
        return ret;
    }

    private int deductionsFromSelfTower(int[][] toy) {
        int ret = 0;
        for (int row = 0; row < toy.length; ++row) {
            for (int col = 0; col < toy[row].length; ++col) {
                if (toy[row][col] == 1) {
                    continue;
                }
                ret += 2 + 2 * (toy[row][col] - 2);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final ThreeDSurfaceArea app = new ThreeDSurfaceArea();
        try (Scanner in = new Scanner(System.in)) {
            final String[] heightAndWidthStr = in.nextLine().split(" ");
            final int height = Integer.parseInt(heightAndWidthStr[0]);
            final int width = Integer.parseInt(heightAndWidthStr[1]);
            final int[][] toy = new int[height][width];
            for (int i = 0; i < height; ++i) {
                final String[] widthsStr = in.nextLine().split(" ");
                for (int j = 0; j < widthsStr.length; ++j) {
                    toy[i][j] = Integer.parseInt(widthsStr[j]);
                }
            }
            System.out.println(app.surfaceArea(toy));
        }
    }
}
