package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class AppendAndDelete {
    private int commonAncestorLength(final String s1, final String s2) {
        int ret = 0;
        int upperBound = Math.min(s1.length(), s2.length());
        for (int i = 0; i < upperBound; ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                ++ret;
            } else {
                break;
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final String initialString = in.next();
            final String desiredFinalString = in.next();
            final int desiredNumberOfOperations = in.nextInt();
            final AppendAndDelete app = new AppendAndDelete();
            final int commonAncestorLength = app.commonAncestorLength(initialString, desiredFinalString);
            final int minOperationsNeeded = (initialString.length() - commonAncestorLength) + (desiredFinalString.length() - commonAncestorLength);
            if (minOperationsNeeded == desiredNumberOfOperations) {
                System.out.println("Yes");
            } else if (minOperationsNeeded > desiredNumberOfOperations) {
                System.out.println("No");
            } else {
                final int operationsUntilBlank = initialString.length();
                final int operationsWithReduceToBlank = operationsUntilBlank + desiredFinalString.length();
                if (operationsWithReduceToBlank <= desiredNumberOfOperations) {
                    System.out.println("Yes");    
                } else {
                    if ((minOperationsNeeded % 2 == 0 && desiredNumberOfOperations % 2 == 0) ||
                            (minOperationsNeeded % 2 == 1 && desiredNumberOfOperations % 2 == 1)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");        
                    }
                }
            }
        }
    }
}
