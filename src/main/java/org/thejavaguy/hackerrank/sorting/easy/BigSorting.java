package org.thejavaguy.hackerrank.sorting.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class BigSorting {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            List<String> unsorted = new ArrayList<>();
            Comparator<String> byLengthAndLexicographically = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }
                    byte[] b1 = o1.getBytes();
                    byte[] b2 = o2.getBytes();
                    for (int i = 0; i < b1.length; ++i) {
                        if (b1[i] < b2[i]) {
                            return -1;
                        }
                        if (b1[i] > b2[i]) {
                            return 1;
                        }
                    }
                    return 0;
                }
            };
            for (int i = 0; i < size; ++i) {
                unsorted.add(in.next());
            }
            Collections.sort(unsorted, byLengthAndLexicographically);
            final int len = unsorted.size();
            final StringBuilder ret = new StringBuilder();
            final String sep = System.lineSeparator();
            for (int i = 0; i < len; ++i) {
                ret.append(unsorted.get(i));
                ret.append(sep);
            }
            System.out.println(ret.toString());
        }
    }
}
