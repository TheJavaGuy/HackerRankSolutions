package org.thejavaguy.hackerrank.implementation.medium;

import java.math.BigInteger;
import java.util.Scanner;

public final class ExtraLongFactorials {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int number = Integer.parseInt(in.nextLine());
            BigInteger factorial = BigInteger.ONE;
            for (int i = number; i >= 2; --i) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
        }
    }
}
