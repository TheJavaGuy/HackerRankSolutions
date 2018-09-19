package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class StringConstruction {
    public int cost(String word) {
        int ret = 0;
        StringBuilder constructed = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            final String currentChar = Character.toString(word.charAt(i));
            if (constructed.indexOf(currentChar) == -1) {
                ++ret;
                constructed.append(currentChar);
            } else {
                constructed.append(currentChar);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final StringConstruction app = new StringConstruction();
        try (Scanner in = new Scanner(System.in)) {
            final int length = Integer.parseInt(in.nextLine());
            for (int i = 0; i < length; ++i) {
                System.out.println(app.cost(in.nextLine()));
            }
        }
    }
}
