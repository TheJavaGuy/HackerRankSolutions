package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class CaesarCipher {
    public String encoded(String cleartext, int rotateBy) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < cleartext.length(); ++i) {
            char currentChar = cleartext.charAt(i);
            if ('a' <= currentChar && currentChar <= 'z') {
                char transformed = (char)(((currentChar - 'a' + rotateBy) % 26) + 'a');
                ret.append(transformed);
            } else if ('A' <= currentChar && currentChar <= 'Z') {
                char transformed = (char)(((currentChar - 'A' + rotateBy) % 26) + 'A');
                ret.append(transformed);
            } else {
                ret.append(currentChar);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        final CaesarCipher app = new CaesarCipher();
        try (Scanner in = new Scanner(System.in)) {
            final int length = Integer.parseInt(in.nextLine());
            final String cleartext = in.nextLine();
            final int rotateBy = Integer.parseInt(in.nextLine());
            System.out.println(app.encoded(cleartext, rotateBy));
        }
    }
}
