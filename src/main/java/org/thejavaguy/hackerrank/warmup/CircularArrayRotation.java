package org.thejavaguy.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author ivan
 *
 */
public class CircularArrayRotation {
    public void rotateRightCircular(final int[] arr) {
        rotateRightCircular(arr, 1);
    }
    
    public void rotateRightCircular(final int[] arr, final int places) {
        final int[] last = new int[places];
        for (int i = 0; i < last.length; ++i) {
            last[i] = arr[arr.length - places + i];
        }
        int writePtr = arr.length - 1;
        int readPtr = writePtr - places;
        for (;;) {
            if (readPtr < 0) {
                break;
            }
            arr[writePtr] = arr[readPtr];
            --writePtr;
            --readPtr;
        }
        for (int i = 0; i < last.length; ++i) {
            arr[i] = last[i];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = null;
        CircularArrayRotation app = new CircularArrayRotation();
        try {
            in = new Scanner(System.in);
            final int numberOfElements = in.nextInt();
            final int numberOfRotations = in.nextInt();
            final int numberOfQueries = in.nextInt();
            int[] arr = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; ++i) {
                arr[i] = in.nextInt();
            }
            int[] queries = new int[numberOfQueries];
            for (int i = 0; i < numberOfQueries; ++i) {
                queries[i] = in.nextInt();
            }
            int realNumberOfRotations = numberOfRotations % numberOfElements;
            app.rotateRightCircular(arr, realNumberOfRotations);
            for (int i = 0; i < numberOfQueries; ++i) {
                System.out.println(arr[queries[i]]);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
