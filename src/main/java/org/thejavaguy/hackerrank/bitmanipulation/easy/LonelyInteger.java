package org.thejavaguy.hackerrank.bitmanipulation.easy;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class LonelyInteger {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfElements = in.nextInt();
            int lonely = 0;
            for (int i = 0; i < numberOfElements; ++i) {
                lonely = lonely ^ in.nextInt();
            }
            System.out.println(lonely);
        }
    }
}
