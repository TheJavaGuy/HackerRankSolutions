package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class PickingNumbers {
    private final Map<Integer, Integer> occurencesByNumber;
    
    public PickingNumbers() {
        this.occurencesByNumber = new TreeMap<>();
    }
    
    public void add(int key) {
        if (occurencesByNumber.containsKey(Integer.valueOf(key))) {
            Integer oldValue = occurencesByNumber.get(Integer.valueOf(key));
            occurencesByNumber.put(Integer.valueOf(key), Integer.valueOf(oldValue.intValue() + 1));
        } else {
            occurencesByNumber.put(Integer.valueOf(key), Integer.valueOf(1));
        }
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final PickingNumbers app = new PickingNumbers();
            final int arraySize = in.nextInt();
            for (int i = 0; i < arraySize; ++i) {
                app.add(in.nextInt());
            }
            int maxNumberOfElements = 0;
            Set<Integer> keys = app.occurencesByNumber.keySet();
            for (Integer currentKey : keys) {
                int currentNumberOfElements = app.occurencesByNumber.get(currentKey).intValue();
                Optional<Integer> nextKey = keys.stream().filter(p -> p.intValue() == currentKey.intValue() + 1).findFirst();
                if (nextKey.isPresent()) {
                    currentNumberOfElements += app.occurencesByNumber.get(nextKey.get()).intValue();
                }
                if (currentNumberOfElements > maxNumberOfElements) {
                    maxNumberOfElements = currentNumberOfElements;
                }
            }
            System.out.println(maxNumberOfElements);
        }
    }
}
