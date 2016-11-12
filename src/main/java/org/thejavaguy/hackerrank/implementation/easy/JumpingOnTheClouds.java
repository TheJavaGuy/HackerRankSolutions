package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class JumpingOnTheClouds {
    public boolean canJumpTwo(final int[] clouds, final int currentCloud) {
        if (currentCloud >= clouds.length - 2) {
            return false;
        }
        return clouds[currentCloud + 2] == 0;
    }

    public static void main(String[] args) {
        final JumpingOnTheClouds app = new JumpingOnTheClouds();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfClouds = in.nextInt();
            final int[] clouds = new int[numberOfClouds];
            for (int cloudPtr = 0; cloudPtr < numberOfClouds; ++cloudPtr) {
                clouds[cloudPtr] = in.nextInt();
            }
            int currentCloud = 0;
            int numberOfJumps = 0;
            for (;;) {
                if (currentCloud == numberOfClouds - 1) {
                    break;
                }
                if (app.canJumpTwo(clouds, currentCloud)) {
                    currentCloud += 2;
                } else {
                    ++currentCloud;
                }
                ++numberOfJumps;
            }
            System.out.println(numberOfJumps);
        }
    }
}
