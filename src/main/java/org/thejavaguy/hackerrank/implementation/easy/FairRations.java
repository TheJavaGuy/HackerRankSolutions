package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class FairRations {
    private boolean everyoneHasEvenNumberOfLoaves(int[] loaves) {
        for (int current : loaves) {
            if (current % 2 != 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean impossible(int[] loaves) {
        int numberOfOdds = 0;
        for (int current : loaves) {
            if (current % 2 != 0) {
                ++numberOfOdds;
            }
        }
        if (numberOfOdds % 2 != 0) {
            return true;
        }
        return false;
    }
    
    private void distributeOneLoaf(int[] loaves) {
        int indexOfFirstOdd = -1;
        for (int i = 0; i < loaves.length; ++i) {
            if (loaves[i] % 2 != 0) {
                indexOfFirstOdd = i;
                break;
            }
        }
        loaves[indexOfFirstOdd]++;
        loaves[indexOfFirstOdd+1]++;
    }
    
    public static void main(String[] args) {
        final FairRations app = new FairRations();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSubjects = in.nextInt();
            final int[] initialLoaves = new int[numberOfSubjects];
            for (int i = 0; i < numberOfSubjects; ++i) {
                initialLoaves[i] = in.nextInt();
            }
            final int[] loaves = Arrays.copyOf(initialLoaves, numberOfSubjects);
            int distributed = 0;
            for (;;) {
                if (app.impossible(loaves)) {
                    System.out.println("NO");
                    return;
                }
                if (app.everyoneHasEvenNumberOfLoaves(loaves)) {
                    System.out.println(distributed);
                    return;
                }
                app.distributeOneLoaf(loaves);
                distributed += 2;
            }            
        }
    }
}
