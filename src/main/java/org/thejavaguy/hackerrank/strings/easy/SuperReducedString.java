package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class SuperReducedString {
    private static final String EMPTY_MARKER = "Empty String";

    public String reduce(final String origin) {
        if (origin.isEmpty()) {
            return EMPTY_MARKER;
        }
        if (origin.length() == 1) {
            return origin;
        }
        final char[] originArr = origin.toCharArray();
        final char[] reducedArr = new char[originArr.length - 2];
        int writePtr = 0;
        boolean reduced = false;
        for (int readPtr = 0; readPtr < originArr.length - 1; ++readPtr) {
            int aheadPtr = readPtr + 1;
            if (originArr[readPtr] == originArr[aheadPtr]) {
                reduced = true;
                for (int newReadPtr = readPtr + 2; newReadPtr < originArr.length; ++newReadPtr) {
                    reducedArr[writePtr] = originArr[newReadPtr];
                    ++writePtr;
                }
                break;
            } else {
                if (writePtr < reducedArr.length) {
                    reducedArr[writePtr] = originArr[readPtr];
                    ++writePtr;
                } else {
                    break;
                }
            }
        }
        if (!reduced) {
            return origin;
        } else {
            if (reducedArr.length == 0) {
                return EMPTY_MARKER;
            } else {
                return new String(reducedArr);
            }
        }
    }

    public static void main(String[] args) {
        final SuperReducedString app = new SuperReducedString();
        try (Scanner in = new Scanner(System.in)) {
            final String input = in.nextLine();
            String origin = input;
            for (;;) {
                String reduced = app.reduce(origin);
                if (reduced.equals(origin) || reduced.equals(EMPTY_MARKER)) {
                    System.out.println(reduced);
                    return;
                } else {
                    origin = reduced;
                }
            }
        }
    }
}
