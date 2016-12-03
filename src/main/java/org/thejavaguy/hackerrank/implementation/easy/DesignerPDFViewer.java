package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class DesignerPDFViewer {
    public int maxHeight(String word, int[] heights) {
        int ret = 0;
        for (int i = 0; i < word.length(); ++i) {
            int currentHeight = height(word.charAt(i), heights);
            if (currentHeight > ret) {
                ret = currentHeight;
            }
        }
        return ret;
    }
    
    private int height(char letter, int[] heights) {
        return heights[letter - 'a'];
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int[] heights = new int[26];
            for (int i = 0; i < heights.length; ++i) {
                heights[i] = in.nextInt();
            }
            final String word = in.next();
            DesignerPDFViewer app = new DesignerPDFViewer();
            System.out.println(word.length() * app.maxHeight(word, heights));
        }
    }
}
