package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class PriyankAndToys {
    public static void main(String[] args) {
        final PriyankAndToys app = new PriyankAndToys();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfOrders = Integer.parseInt(in.nextLine());
            final String[] weightsStr = in.nextLine().split(" ");
            Set<Integer> weights = new TreeSet<>();
            for (int i = 0; i < weightsStr.length; ++i) {
                weights.add(Integer.valueOf(weightsStr[i]));
            }
            int numberOfContainers = 0;
            for (;;) {
                int min = weights.iterator().next();
                weights.removeIf(weight -> weight.intValue() <= min + 4);
                ++numberOfContainers;
                if (weights.isEmpty()) {
                    break;
                }
            }
            System.out.println(numberOfContainers);
        }
    }
}
