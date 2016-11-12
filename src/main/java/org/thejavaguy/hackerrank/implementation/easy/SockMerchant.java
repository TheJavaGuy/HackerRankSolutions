package org.thejavaguy.hackerrank.implementation.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SockMerchant {
    private int pairs(final int[] colors) {
        int ret = 0;
        Map<Integer, Integer> occurencesByColor = new HashMap<>();
        for (int i = 0; i < colors.length; ++i) {
            if (occurencesByColor.containsKey(colors[i])) {
                occurencesByColor.put(colors[i], occurencesByColor.get(colors[i]) + 1);
            } else {
                occurencesByColor.put(colors[i], 1);
            }
        }
        Set<Integer> keys = occurencesByColor.keySet();
        for (Integer key : keys) {
            ret += occurencesByColor.get(key) / 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSocks = in.nextInt();
            final int[] colors = new int[numberOfSocks];
            for (int i = 0; i < numberOfSocks; ++i) {
                colors[i] = in.nextInt();
            }
            SockMerchant app = new SockMerchant();
            System.out.print(app.pairs(colors));
        }
    }
}
