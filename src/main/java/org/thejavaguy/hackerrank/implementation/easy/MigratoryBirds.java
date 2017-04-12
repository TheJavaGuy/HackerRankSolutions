package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MigratoryBirds {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfBirds = in.nextInt();
            final Map<Integer, Integer> occurences = new TreeMap<>();
            for (int i = 0; i < numberOfBirds; ++i) {
                final int currentBirdType = in.nextInt();
                final Integer key = Integer.valueOf(currentBirdType);
                if (occurences.containsKey(key)) {
                    int oldValue = occurences.get(key).intValue();
                    Integer newValue = Integer.valueOf(oldValue + 1);
                    occurences.put(key, newValue);
                } else {
                    occurences.put(key, Integer.valueOf(1));
                }                
            }
            int mostCommonType = Integer.MIN_VALUE;
            int mostOccurences = Integer.MIN_VALUE;
            for (Integer currentKey : occurences.keySet()) {
                if (occurences.get(currentKey).intValue() > mostOccurences) {
                    mostCommonType = currentKey.intValue();
                    mostOccurences = occurences.get(currentKey).intValue();
                }
            }
            System.out.println(mostCommonType);
        }
    }
}
