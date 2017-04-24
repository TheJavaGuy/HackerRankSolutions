package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class EqualizeTheArray {
    private final Map<Integer, Integer> occurencesByNumber;
    
    public EqualizeTheArray() {
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
            final int numberOfElements = in.nextInt();
            if (numberOfElements == 1) {
                System.out.println(0);
                return;
            }
            final EqualizeTheArray app = new EqualizeTheArray();
            for (int i = 0; i < numberOfElements; ++i) {
                app.add(in.nextInt());
            }
            Collection<Integer> occurences = app.occurencesByNumber.values();
            int maxOccurence = 0;
            for (Integer currentOccurence : occurences) {
                if (currentOccurence.intValue() > maxOccurence) {
                    maxOccurence = currentOccurence.intValue();
                }
            }
            System.out.println(numberOfElements - maxOccurence);
        }
    }
}
