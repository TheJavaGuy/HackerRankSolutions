package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class UtopianTree {
    private static final int STARTING_HEIGHT = 1;
    
    public int height(int cycles) {
        if (cycles == 0) {
            return STARTING_HEIGHT;
        }
        int ret = STARTING_HEIGHT;
        for (int cycle = 0; cycle < cycles; ++cycle) {
            if (isSpringCycle(cycle)) {
                ret *= 2;
            } else {
                ++ret;
            }
        }
        return ret;
    }
    
    private boolean isSpringCycle(int cycle) {
        return cycle % 2 == 0;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTestCases = in.nextInt();
            final int[] cycles = new int[numberOfTestCases];
            for (int i = 0; i < cycles.length; ++i) {
                cycles[i] = in.nextInt();
            }
            UtopianTree app = new UtopianTree();
            for (int cycle : cycles) {
                System.out.println(app.height(cycle));
            }
        }
    }
}
