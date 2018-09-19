package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class MarsExploration {
    public int marsExploration(String message) {
        int ret = 0;
        for (int pos = 0; pos < message.length(); ++pos) {
            if (pos % 3 == 0 || pos % 3 == 2) {
                if (message.charAt(pos) != 'S') {
                    ++ret;
                }
            } else if (pos % 3 == 1) {
                if (message.charAt(pos) != 'O') {
                    ++ret;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        final MarsExploration app = new MarsExploration();
        try (Scanner in = new Scanner(System.in)) {
            String message = in.nextLine();
            System.out.println(app.marsExploration(message));
        }
    }
}
