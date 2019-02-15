package org.thejavaguy.hackerrank.implementation.medium;

import java.util.Scanner;

public final class Encryption {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final String withoutSpaces = in.nextLine().replaceAll("\\s+", "");
            int rows = (int)Math.floor(Math.sqrt(withoutSpaces.length()));
            int columns = (int)Math.ceil(Math.sqrt(withoutSpaces.length()));
            if (rows * columns < withoutSpaces.length()) {
                rows = columns;
            }
            for (int currentColumn = 0; currentColumn < columns; ++currentColumn) {
                for (int currentRow = 0; currentRow < rows; ++currentRow) {
                    int currentIndex = (currentRow * columns) + currentColumn;
                    if (withoutSpaces.length() > currentIndex) {
                        System.out.print(withoutSpaces.charAt(currentIndex));
                    }
                }
                System.out.print(' ');
            }
        }
    }
}
