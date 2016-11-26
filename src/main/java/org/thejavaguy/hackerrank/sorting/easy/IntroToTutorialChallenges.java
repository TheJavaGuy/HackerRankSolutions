package org.thejavaguy.hackerrank.sorting.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class IntroToTutorialChallenges {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int valueToSearch = in.nextInt();
            int sizeOfArray = in.nextInt();
            for (int i = 0; i < sizeOfArray; ++i) {
                int ithElement = in.nextInt();
                if (valueToSearch == ithElement) {
                    System.out.println(i);
                }
            }
        }
    }
}
