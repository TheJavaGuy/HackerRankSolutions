package org.thejavaguy.hackerrank.strings.easy;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ivan
 *
 */
public final class Pangrams {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final String s = in.nextLine();
            final String lowercased = s.toLowerCase(Locale.UK);
            final String nospaces = lowercased.replaceAll("\\s+", "");
            Set<Character> allChars = new HashSet<>();
            for (char c = 'a'; c <= 'z'; ++c) {
                allChars.add(Character.valueOf(c));
            }
            Set<Character> inputChars = new HashSet<>();
            for (int i = 0; i < nospaces.length(); ++i) {
                inputChars.add(Character.valueOf(nospaces.charAt(i)));
            }
            if (allChars.size() == inputChars.size()) {
                System.out.println("pangram");
            } else {
                System.out.println("not pangram");
            }
        }
    }
}
