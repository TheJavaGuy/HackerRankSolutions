package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class BetweenTwoSets {
    public int max(int[] arr) {
        int ret = Integer.MIN_VALUE;
        for (int elem : arr) {
            if (elem > ret) {
                ret = elem;
            }
        }
        return ret;
    }
    
    public int min(int[] arr) {
        int ret = Integer.MAX_VALUE;
        for (int elem : arr) {
            if (elem < ret) {
                ret = elem;
            }
        }
        return ret;
    }
    
    public Set<Integer> candidates(int from, int to) {
        Set<Integer> ret = new TreeSet<>();
        for (int candidate = from; candidate <= to; ++candidate) {
            ret.add(Integer.valueOf(candidate));
        }
        return ret;
    }
    
    public boolean isFactor(int smaller, int larger) {
        return larger % smaller == 0;
    }
    
    public boolean allElementsAreFactor(int[] arr, int x) {
        for (int element : arr) {
            if (!isFactor(element, x)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isFactorOfAllElements(int x, int[] arr) {
        for (int element : arr) {
            if (!isFactor(x, element)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            final int[] b = new int[m];
            for (int i = 0; i < m; ++i) {
                b[i] = in.nextInt();
            }
            BetweenTwoSets app = new BetweenTwoSets();
            Set<Integer> candidates = app.candidates(app.max(a), app.min(b));
            int numberOfBetween = 0;
            for (Integer candidate : candidates) {
                if (app.allElementsAreFactor(a, candidate) && app.isFactorOfAllElements(candidate, b)) {
                    ++numberOfBetween;
                }
            }
            System.out.println(numberOfBetween);
        }
    }
}
