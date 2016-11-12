package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class StrangeCounter {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final long t = in.nextLong();
            final int cycleBaseSize = 3;
            int currentCycle = 0;
            long timeStart = 0;
            long timeFinish = 0;
            for (;;) {
                long cycleSize = (1 << currentCycle) * cycleBaseSize;
                timeStart = timeFinish + 1;
                timeFinish = cycleSize + timeStart - 1;
                if (t >= timeStart && t <= timeFinish) {
                    System.out.println(timeFinish - t + 1);
                    return;
                }
                ++currentCycle;
            }
        }
    }
}
