package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class ModifiedKaprekarNumbers {
    public boolean isKaprekarNumber(final int number) {
        final int digitsInOriginalNumber = numberOfDigits(number);
        final long square = square(number);
        final int digitsInSquare = numberOfDigits(square);
        final int rightmost = rightmostDigits(square, digitsInOriginalNumber);
        final int leftmost = leftmostDigits(square, digitsInSquare - digitsInOriginalNumber);
        return rightmost + leftmost == number;
    }
    
    private int numberOfDigits(final int number) {
        return String.valueOf(number).length();
    }
    
    private int numberOfDigits(final long number) {
        return String.valueOf(number).length();
    }
    
    private long square(final int number) {
        return (long)number * number;
    }
    
    private int rightmostDigits(final long number, final int digits) {
        if (digits == 0) {
            return 0;
        }
        String numberAsString = String.valueOf(number);
        String rightmost = numberAsString.substring(numberAsString.length() - digits);
        return Integer.parseInt(rightmost);
    }
    
    private int leftmostDigits(final long number, final int digits) {
        if (digits == 0) {
            return 0;
        }
        String numberAsString = String.valueOf(number);
        String leftmost = numberAsString.substring(0, digits);
        return Integer.parseInt(leftmost);
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int lowest = in.nextInt();
            final int highest = in.nextInt();
            final ModifiedKaprekarNumbers app = new ModifiedKaprekarNumbers();
            boolean hasOne = false;
            for (int i = lowest; i <= highest; ++i) {
                if (app.isKaprekarNumber(i)) {
                    hasOne = true;
                    System.out.print(i);
                    System.out.print(" ");
                };
            }
            if (!hasOne) {
                System.out.println("INVALID RANGE");
            }
        }
    }
}
