package org.thejavaguy.hackerrank.implementation.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class CavityMap {
    private void addNeighbourNorth(String[] grid, int row, int col, List<Character> neighbours) {
        int newRow = row - 1;
        int newCol = col;
        if (newRow < 0) {
            return;
        }
        neighbours.add(Character.valueOf(grid[newRow].charAt(newCol)));
    }
    
    private void addNeighbourSouth(String[] grid, int row, int col, List<Character> neighbours) {
        int newRow = row + 1;
        int newCol = col;
        if (newRow >= grid.length) {
            return;
        }
        neighbours.add(Character.valueOf(grid[newRow].charAt(newCol)));
    }
    
    private void addNeighbourEast(String[] grid, int row, int col, List<Character> neighbours) {
        int newRow = row;
        int newCol = col + 1;
        if (newCol >= grid.length) {
            return;
        }
        neighbours.add(Character.valueOf(grid[newRow].charAt(newCol)));
    }
    
    private void addNeighbourWest(String[] grid, int row, int col, List<Character> neighbours) {
        int newRow = row;
        int newCol = col - 1;
        if (newCol < 0) {
            return;
        }
        neighbours.add(Character.valueOf(grid[newRow].charAt(newCol)));
    }

    public List<Character> neighbours(String[] grid, int row, int col) {
        List<Character> ret = new ArrayList<>();
        addNeighbourNorth(grid, row, col, ret);
        addNeighbourEast(grid, row, col, ret);
        addNeighbourSouth(grid, row, col, ret);
        addNeighbourWest(grid, row, col, ret);
        return ret;
    }
    
    public boolean isCavity(String[] grid, int row, int col, List<Character> neighbours) {
        if (row == 0 || col == 0 || row == grid.length-1 || col == grid.length-1) {
            return false;
        }
        Character max = Collections.max(neighbours);
        if (grid[row].charAt(col) > max.charValue()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        final CavityMap app = new CavityMap();
        try (Scanner in = new Scanner(System.in)) {
            final int mapSize = in.nextInt();
            final String[] grid = new String[mapSize];
            for (int gridPtr = 0; gridPtr < mapSize; ++gridPtr) {
                grid[gridPtr] = in.next();
            }
            for (int row = 0; row < mapSize; ++row) {
                String copyRow = "";
                for (int col = 0; col < mapSize; ++col) {
                    List<Character> neighbours = app.neighbours(grid, row, col);
                    if (app.isCavity(grid, row, col, neighbours)) {
                        copyRow += "X";
                    } else {
                        copyRow += grid[row].charAt(col);
                    }
                }
                System.out.println(copyRow);
            }
        }
    }
}
