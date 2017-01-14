package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class JumpingOnTheCloudsRevisited {
    private boolean isThunderCloud(final int[] clouds, final int cloudIndex) {
        return clouds[cloudIndex] == 1;
    }

    public static void main(String[] args) {
        JumpingOnTheCloudsRevisited app = new JumpingOnTheCloudsRevisited();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfClouds = in.nextInt();
            final int jumpSize = in.nextInt();
            final int[] clouds = new int[numberOfClouds];
            for (int cloudPtr = 0; cloudPtr < numberOfClouds; ++cloudPtr) {
                clouds[cloudPtr] = in.nextInt();
            }
            int currentCloud = 0;
            int numberOfJumps = 0;
            int energyLevel = 100;
            for (;;) {
                if (numberOfJumps > 0 && currentCloud == 0) {
                    break;
                }
                ++numberOfJumps;
                currentCloud = (currentCloud + jumpSize) % numberOfClouds;
                --energyLevel;
                if (app.isThunderCloud(clouds, currentCloud)) {
                    energyLevel -= 2;
                }
            }
            System.out.println(energyLevel);
        }
    }
}
