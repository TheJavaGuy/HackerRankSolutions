package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class ElectronicsShop {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int amountOfMoney = in.nextInt();
            final int numberOfKeyboardBrands = in.nextInt();
            final int numberOfUSBBrands = in.nextInt();
            final int[] pricesOfKeyboards = new int[numberOfKeyboardBrands];
            final int[] pricesOfUSBs = new int[numberOfUSBBrands];
            for (int i = 0; i < numberOfKeyboardBrands; ++i) {
                pricesOfKeyboards[i] = in.nextInt();
            }
            for (int j = 0; j < numberOfUSBBrands; ++j) {
                pricesOfUSBs[j] = in.nextInt();
            }
            Arrays.sort(pricesOfKeyboards);
            Arrays.sort(pricesOfUSBs);
            if (amountOfMoney < pricesOfKeyboards[0] + pricesOfUSBs[0]) {
                System.out.println(-1);
                return;
            }
            if (amountOfMoney >= pricesOfKeyboards[numberOfKeyboardBrands-1] + pricesOfUSBs[numberOfUSBBrands-1]) {
                System.out.println(pricesOfKeyboards[numberOfKeyboardBrands-1] + pricesOfUSBs[numberOfUSBBrands-1]);
                return;
            }
            int currentMax = 0;
            for (int i = 0; i < numberOfKeyboardBrands; ++i) {
                for (int j = 0; j < numberOfUSBBrands; ++j) {
                    if (pricesOfKeyboards[i] + pricesOfUSBs[j] > currentMax && pricesOfKeyboards[i] + pricesOfUSBs[j] <= amountOfMoney) {
                        currentMax = pricesOfKeyboards[i] + pricesOfUSBs[j];
                    }
                }
            }
            System.out.println(currentMax);
        }
    }
}
