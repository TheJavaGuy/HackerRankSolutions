package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class CatsAndMouse {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfQueries = in.nextInt();
            for (int i = 0; i < numberOfQueries; ++i) {
                final int catA = in.nextInt();
                final int catB = in.nextInt();
                final int mouseC = in.nextInt();
                final int diffAC = Math.abs(catA - mouseC);
                final int diffBC = Math.abs(catB - mouseC);
                if (diffAC == diffBC) {
                    System.out.println("Mouse C");
                } else if (diffAC < diffBC) {
                    System.out.println("Cat A");
                } else {
                    System.out.println("Cat B");
                }
            }
        }
    }
}
