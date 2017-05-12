package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class HappyLadybugs {
    private boolean hasEmptySpace(final char[] ladybugs) {
        for (char currentCell : ladybugs) {
            if (currentCell == '_') {
                return true;
            }
        }
        return false;
    }
    
    private boolean[] happiness(final char[] ladybugs) {
        boolean[] ret = new boolean[ladybugs.length];
        for (int i = 0; i < ladybugs.length; ++i) {
            if (ladybugs[i] == '_') {
                ret[i] = true;
                continue;
            }
            if (ret[i]) {
                continue;
            }
            if (i == 0) {
                if (ladybugs[i] == ladybugs[i+1]) {
                    ret[i] = true;
                    ret[i+1] = true;
                }
            } else if (i > 0 && i < ladybugs.length - 1) {
                if (ladybugs[i] == ladybugs[i-1]) {
                    ret[i] = true;
                    ret[i-1] = true;
                }
                if (ladybugs[i] == ladybugs[i+1]) {
                    ret[i] = true;
                    ret[i+1] = true;
                }
            } else {
                if (ladybugs[i] == ladybugs[i-1]) {
                    ret[i] = true;
                    ret[i-1] = true;
                }
            }
        }
        return ret;
    }
    
    private boolean areAllHappy(final boolean[] happiness) {
        for (boolean currentHappiness : happiness) {
            if (!currentHappiness) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfGames = in.nextInt();
            for (int i = 0; i < numberOfGames; ++i) {
                final HappyLadybugs app = new HappyLadybugs();
                final int numberOfCells = Integer.parseInt(in.next());
                final String board = in.next();
                if (numberOfCells == 1) {
                    if (board.equals("_")) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    continue;
                }
                char[] ladybugs = new char[numberOfCells];
                for (int currentCell = 0; currentCell < board.length(); ++currentCell) {
                    ladybugs[currentCell] = board.charAt(currentCell);
                }
                if (app.hasEmptySpace(ladybugs)) {
                    Arrays.sort(ladybugs);
                }
                boolean[] hap = app.happiness(ladybugs);
                System.out.println(app.areAllHappy(hap) ? "YES" : "NO");
            }
        }
    }
}
