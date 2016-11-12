package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan
 *
 */
public final class RepeatedString {
	public int occurences(final char ch, final String string) {
		int ret = 0;
		for (int i = 0; i < string.length(); ++i) {
			if (string.charAt(i) == ch) {
				++ret;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		final RepeatedString app = new RepeatedString();
		try (Scanner in = new Scanner(System.in)) {
			final String s = in.nextLine();
			final long n = in.nextLong();
			final long wholeParts = n / s.length();
			final long lengthOfFractionalPart = n % s.length();
			long numberOfAs = 0;
			if (wholeParts > 0) {
				numberOfAs += wholeParts * app.occurences('a', s);
			}
			numberOfAs += app.occurences('a', s.substring(0, (int)lengthOfFractionalPart));
			System.out.println(numberOfAs);
		}
	}

}
