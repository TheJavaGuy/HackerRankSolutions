package org.thejavaguy.hackerrank.greedy.easy;

import java.util.Scanner;

public final class BeautifulPairs {
    private int elementWithMaxOccurrences(int[] arrOccurrences) {
        int ret = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arrOccurrences.length; ++i) {
            if (arrOccurrences[i] > max) {
                ret = i;
                max = arrOccurrences[i];
            }
        }
        return ret;
    }

    private int existsInAbutNotInB(int[] arrAoccurrences, int[] arrBoccurrences) {
        for (int i = 1; i < arrAoccurrences.length; ++i) {
            if (arrAoccurrences[i] > 0 && arrBoccurrences[i] == 0) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    private void changeOnce(int oldValue, int newValue, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == oldValue) {
                arr[i] = newValue;
                return;
            }
        }
    }

    public static void main(String[] args) {
        final BeautifulPairs app = new BeautifulPairs();
        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.parseInt(in.nextLine());
            final String[] aStr = in.nextLine().split(" ");
            final String[] bStr = in.nextLine().split(" ");
            final int[] arrA = new int[size];
            final int[] arrB = new int[size];
            final int[] arrAoccurrences = new int[1001];
            final int[] arrBoccurrences = new int[1001];
            for (int i = 0; i < arrA.length; ++i) {
                arrA[i] = Integer.parseInt(aStr[i]);
                arrB[i] = Integer.parseInt(bStr[i]);
                ++arrAoccurrences[arrA[i]];
                ++arrBoccurrences[arrB[i]];
            }
            final int mostFrequentInB = app.elementWithMaxOccurrences(arrBoccurrences);
            final int existsOnlyInA = app.existsInAbutNotInB(arrAoccurrences, arrBoccurrences);
            app.changeOnce(mostFrequentInB, existsOnlyInA, arrB);
        }
    }
}
