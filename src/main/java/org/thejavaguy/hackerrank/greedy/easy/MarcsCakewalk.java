package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MarcsCakewalk {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numCalorie = Integer.parseInt(in.nextLine());
            final String[] calorieStr = in.nextLine().split(" ");
            final Integer[] calorie = new Integer[numCalorie];
            for (int i = 0; i < numCalorie; ++i) {
                calorie[i] = Integer.decode(calorieStr[i]);
            }
            Arrays.sort(calorie, Collections.reverseOrder());
            long ret = 0;
            for (int i = 0; i < numCalorie; ++i) {
                ret += Math.pow(2, i) * calorie[i];
            }
            System.out.println(ret);
        }
    }
}
